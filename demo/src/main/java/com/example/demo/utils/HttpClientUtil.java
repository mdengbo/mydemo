package com.example.demo.utils;

import com.example.demo.entity.NewsManagementSaveDTO;
import lombok.extern.slf4j.Slf4j;
import org.jsoup.Jsoup;
import org.jsoup.nodes.Document;
import org.jsoup.nodes.Element;
import org.jsoup.select.Elements;
import org.springframework.util.StringUtils;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Date;
import java.util.List;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

@Slf4j
public class HttpClientUtil {
    private static final String NEWS_URL = "http://www.gzgov.gov.cn/xwdt/jrgz/";
    /*记者标记*/
    private static final String USER_TAG = "记者";
    /*分页标记*/
    private static final String PAGE_TAG = "createPageHTML(";
    /*初始页码*/
    private static final int PAGE_INIT = 0;
    /*页码占位标记*/
    private static final String PLACEHOLDER = "{num}";
    /*页码url拼接*/
    private static final String PAGE_PLACEHOLDER = "index_" + PLACEHOLDER + ".html";
    /*url尾链标记*/
    private static final String[] URL_TAILING = {"/t", "_", "."};

    /**
     * 查询每一页的新闻列表
     *
     * @param url          分页列表url
     * @param grabbingTime 截取时间，只截取新闻发布时间大于该参数的条目
     * @param dtos         新闻添加集合引用
     * @return 返回true则继续递归下一个index页面, false则代表时间截取或其他原因不在进行递归
     */
    public static Boolean findIndex(String url, Date grabbingTime, List<NewsManagementSaveDTO> dtos) {
        try {
            Document doc = Jsoup.connect(url).get();
            Elements elements = doc.getElementsByClass("right-list-box").select("a[href]");
            // 遍历新闻列表每个新闻项
            ergodicNews(elements, dtos, grabbingTime);
        } catch (Exception e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
        }
        return true;
    }

    /**
     * 新闻数据获取方法
     *
     * @param url          新闻今日关注列表默认url： http://www.gzgov.gov.cn/xwdt/jrgz/
     * @param grabbingTime 截取时间：只截取发布时间大于该时间的新闻
     * @return 新闻收集返回实体集合
     */
    public static List<NewsManagementSaveDTO> findIndexInit(Date grabbingTime) {
        List<NewsManagementSaveDTO> dtos = new ArrayList<>();
        try {
            Document doc = Jsoup.connect(NEWS_URL).get();

            //获取每条新闻的链接
            Elements elements = doc.getElementsByClass("right-list-box").select("a[href]");

            //分页最大数,用于获取分页内容
            Elements pages = doc.getElementsByClass("page").addClass("up").addClass("leaidx");

            // 遍历新闻列表每个新闻项
            ergodicNews(elements, dtos, grabbingTime);

            // 遍历今日关注新闻的每一页内容
            int page = PAGE_INIT;
            // 基本url前缀
            String baseUrl = null;
            for (Element question : pages) {
                String pageTemp = question.html();
                if (pageTemp.indexOf(PAGE_TAG) != -1) {
                    pageTemp = pageTemp.substring(pageTemp.indexOf(PAGE_TAG) + PAGE_TAG.length(), pageTemp.length());
                    pageTemp = pageTemp.substring(0, pageTemp.indexOf(","));
                    try {
                        page = Integer.valueOf(pageTemp);
                    } catch (Exception e) {
                        e.printStackTrace();
                    }
                    baseUrl = question.baseUri();
                }

                //执行分页查询操作
                String placeholder = null;
                if (page > 0 && !StringUtils.isEmpty(baseUrl)) {
                    for (int i = 1; i < page; i++) {
                        placeholder = PAGE_PLACEHOLDER;
                        placeholder = placeholder.replace(PLACEHOLDER, String.valueOf(i));
                        if (!findIndex(baseUrl + placeholder, grabbingTime, dtos)) {
                            break;
                        }
                    }
                }
            }
        } catch (Exception e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
        }
        System.out.println(dtos);
        System.out.println(dtos.size());
        return dtos;
    }

    public static NewsManagementSaveDTO findNews(String url, Date grabbingTime) {
        NewsManagementSaveDTO dto = new NewsManagementSaveDTO();
        try {
            Document doc = Jsoup.connect(url).timeout(50000).get();
            Elements news_title = doc.getElementsByClass("Article_bt").select("h1");
            Elements news_time = doc.getElementsByClass("Article_ly").addClass("leaidx");
            Elements news_user = doc.getElementsByClass("zw-con").select("p");
            Elements news_pics = doc.getElementsByClass("zw-con").select("p").select("img[src]");

            String title = null;
            Date time = null;
            String user = null;
            String pics = null;

            // 获取新闻标题
            for (Element question : news_title) {
                title = question.text();
                dto.setNewsTitle(title);
                break;
            }
            // 获取新闻发布时间
            for (Element question : news_time) {
                String regex = "\\d{4}-\\d{2}-\\d{2} \\d{2}:\\d{2}:\\d{2}";
                Pattern p = Pattern.compile(regex);
                Matcher matcher = p.matcher(question.text());
                if (matcher.find()) {
                    time = getTime(matcher.group(0));
                    if (grabbingTime != null && time.getTime() <= grabbingTime.getTime()) {
                        return null;
                    }
                    dto.setPublicationTime(time);
                }
                break;
            }
            // 获取新闻发布人
            Collections.reverse(news_user);
            for (Element question : news_user) {
                user = question.text();
                int leftIndex = user.lastIndexOf("(") + 1;

                int rightIndex = user.lastIndexOf(")");
                if (leftIndex < rightIndex && (user.length() - 2 < rightIndex)) {
                    if (user.indexOf(USER_TAG) > -1) {
                        user = user.substring(leftIndex, rightIndex);
                        user = user.substring(user.indexOf(USER_TAG) + USER_TAG.length(), user.length());
                        break;
                    } else if (rightIndex - leftIndex < 10 && (user.length() - 2 < rightIndex)) {
                        user = user.substring(leftIndex, rightIndex);
                        break;
                    }
                } else {
                    user = null;
                }
            }
            dto.setPostedByName(user);
            //设置新闻类型
            dto.setNewsType("今日关注");
            //设置新闻来源
            dto.setNewsSource("贵州省人民政府");
            String new_pic = news_pics.size() == 0 ? null : url.substring(0, url.lastIndexOf("/")) + news_pics.first().attr("src").substring(1, news_pics.first().attr("src").length());
            //设置新闻图标
            dto.setNewsBigIcon(new_pic);
            dto.setNewsSmallIcon(new_pic);
            dto.setSourceUrl(url);
            dto.setObtainType(1);
            return dto;
        } catch (Exception e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
        }
        return null;
    }

    private static Date getTime(String str) {
        SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
        try {
            return sdf.parse(str);
        } catch (ParseException e) {
            e.printStackTrace();
        }
        return null;
    }
//
//    public static void main(String[] args) {
//        // 这里采用循环的方式去除列表
//        String url = "http://www.gzgov.gov.cn/xwdt/jrgz/";
//        String time = "2018-09-28 08:57:00";
//
//        Date date = null;
//        SimpleDateFormat formatter = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
//        try {
//            date = formatter.parse(time);
//        } catch (ParseException e) {
//            e.printStackTrace();
//        }
//
//        List<NewsManagementSaveDTO> list = new ArrayList<>();
//    }

    public static void ergodicNews(Elements elements, List<NewsManagementSaveDTO> dtos, Date grabbingTime) {
        // 遍历新闻列表每个新闻项
        for (Element question : elements) {
            NewsManagementSaveDTO dto = findNews(question.attr("href"), grabbingTime);
            //当dto为空那么意味着该条新闻过时了或者其他原因，停止继续获取
            if (dto != null) {
                dtos.add(dto);
            } else {
                break;
            }
        }
    }
}