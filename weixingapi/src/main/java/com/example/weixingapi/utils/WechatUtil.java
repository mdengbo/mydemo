package com.example.weixingapi.utils;

import com.alibaba.fastjson.JSON;
import com.alibaba.fastjson.JSONArray;
import com.alibaba.fastjson.JSONException;
import com.alibaba.fastjson.JSONObject;
import com.example.weixingapi.entity.MaterialParam;
import com.example.weixingapi.entity.MaterialReturn;
import com.example.weixingapi.entity.PerParam;
import com.example.weixingapi.entity.TokenParam;
import lombok.extern.slf4j.Slf4j;

import javax.net.ssl.HttpsURLConnection;
import javax.net.ssl.SSLContext;
import javax.net.ssl.SSLSocketFactory;
import javax.net.ssl.TrustManager;
import java.io.BufferedReader;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.io.OutputStream;
import java.net.ConnectException;
import java.net.URL;
import java.time.Instant;
import java.time.LocalDateTime;
import java.time.ZoneId;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

/**
 * @author madengbo
 * @create 2019-05-21 16:55
 * @desc 工具类
 * @Version 1.0
 **/
@Slf4j
public class WechatUtil {

    /**
     * 凭证获取
     * 获取access_token
     * */
    public final static String TOKEN_URL = "https://api.weixin.qq.com/cgi-bin/token?grant_type=client_credential&appid=APPID&secret=APPSECRET";
    /**
     获取素材列表
     * */
    public final static String MATERIAL = "https://api.weixin.qq.com/cgi-bin/material/batchget_material?access_token=ACCESS_TOKEN";

    /**
     根据 media_id 获取素材组件信息
     * */
    public final static String MATERIALBYMEDIAID = "https://api.weixin.qq.com/cgi-bin/material/get_material?access_token=ACCESS_TOKEN";

    /**
     * 发送https请求
     *
     * @param requestUrl 请求地址
     * @param requestMethod 请求方式（GET、POST）
     * @param outputStr 提交的数据
     * @return JSONObject(通过JSONObject.get(key)的方式获取json对象的属性值)
     */
    public static JSONObject httpsRequest(String requestUrl, String requestMethod, String outputStr) {
        JSONObject jsonObject = null;
        try {
            // 创建SSLContext对象，并使用我们指定的信任管理器初始化
            TrustManager[] tm = { new MyX509TrustManager() };
            SSLContext sslContext = SSLContext.getInstance("SSL", "SunJSSE");
            sslContext.init(null, tm, new java.security.SecureRandom());
            // 从上述SSLContext对象中得到SSLSocketFactory对象
            SSLSocketFactory ssf = sslContext.getSocketFactory();

            URL url = new URL(requestUrl);
            HttpsURLConnection conn = (HttpsURLConnection) url.openConnection();
            conn.setSSLSocketFactory(ssf);

            conn.setDoOutput(true);
            conn.setDoInput(true);
            conn.setUseCaches(false);
            // 设置请求方式（GET/POST）
            conn.setRequestMethod(requestMethod);

            // 当outputStr不为null时向输出流写数据
            if (null != outputStr) {
                OutputStream outputStream = conn.getOutputStream();
                // 注意编码格式
                outputStream.write(outputStr.getBytes("UTF-8"));
                outputStream.close();
            }

            // 从输入流读取返回内容
            InputStream inputStream = conn.getInputStream();
            InputStreamReader inputStreamReader = new InputStreamReader(inputStream, "utf-8");
            BufferedReader bufferedReader = new BufferedReader(inputStreamReader);
            String str = null;
            StringBuffer buffer = new StringBuffer();
            while ((str = bufferedReader.readLine()) != null) {
                buffer.append(str);
            }

            // 释放资源
            bufferedReader.close();
            inputStreamReader.close();
            inputStream.close();
            inputStream = null;
            conn.disconnect();
            jsonObject = JSONObject.parseObject(buffer.toString());
        } catch (ConnectException ce) {
            log.error("连接超时：{}", ce);
        } catch (Exception e) {
            log.error("https请求异常：{}", e);
        }
        return jsonObject;
    }

    /**
     * 获取接口访问凭证
     *
     * @param appid 凭证
     * @param appsecret 密钥
     * @return
     */
    public static TokenParam getToken(String appid, String appsecret) {

        TokenParam token = null;
        /**
         * 替换相应的参数
         * */
        String requestUrl = TOKEN_URL.replace("APPID", appid).replace("APPSECRET", appsecret);
        /**
         * 发送https请求 发起GET请求获取凭证
         * */
        JSONObject jsonObject = httpsRequest(requestUrl, "GET", null);
        if (null != jsonObject) {
            try {
                token = new TokenParam();
                token.setAccessToken(jsonObject.getString("access_token"));
                token.setExpiresIn(jsonObject.getIntValue("expires_in"));
            } catch (JSONException e) {
                token = null;
                // 获取token失败
                log.error("获取token失败 errcode:{} errmsg:{}", jsonObject.getIntValue("errcode"), jsonObject.getString("errmsg"));
            }
        }
        return token;
    }

    /**
     * 获取素材列表并存入集合中
     * @param accessToken 获取接口凭证的唯一标识
     * @param  materialParam 素材的类型，图片（image）、视频（video）、语音 （voice）、图文（news）
     * @param  materialParam 从全部素材的该偏移位置开始返回，0表示从第一个素材 返回
     * @param  materialParam 返回素材的数量，取值在1到20之间
     * @return
     */
    public static List<MaterialReturn> getMaterial(String accessToken, MaterialParam materialParam) {
        /**
         * 定义图文素材实体类集合
         * */
        List<MaterialReturn> lists = new ArrayList<>();
        /**
         * 定义图文素材实体类集合
         * */
        //替换调access_token
        String requestUrl = MATERIAL.replace("ACCESS_TOKEN", accessToken);
        //将参数对象转换成json字符串
        String outputStr = JSON.toJSONString(materialParam);
        //发送https请求(请求的路径,方式,所携带的参数)
        JSONObject jsonObject = httpsRequest(requestUrl, "POST", outputStr);
        // 如果请求成功
        if (null != jsonObject) {
            try {
                JSONArray jsonArray = jsonObject.getJSONArray("item");
                Integer totalCount = jsonObject.getIntValue("total_count");
                if(null == jsonArray || jsonArray.isEmpty()){
                    log.info("微信公众号返回数据为空！");
                    return lists;
                }
                List<PerParam> perParams = new ArrayList<>();
                for (int i = 0; i < jsonArray.size(); i++) {
                    PerParam perParam = new PerParam();
                    JSONObject itemJson = (JSONObject) jsonArray.get(i);
                    JSONObject contentJson = itemJson.getJSONObject("content");
                    JSONArray arr = contentJson.getJSONArray("news_item");
                    contentJson = (JSONObject) arr.get(0);
                    String title = contentJson.getString("title");
                    //粗粒度的 过滤 未发布的消息  todo:接口细粒度的控制
                    if(title.contains("草稿") || title.isEmpty() || title.length() < 6){
                        continue;
                    }
                    Long dataTime = itemJson.getLong("update_time");
                    Date updateTime = timestamToDatetime(dataTime);
                    perParam.setUpdateTime(updateTime);
                    //获取组件的 media_id
                    String mediaId = itemJson.getString("media_id");
                    perParam.setMediaId(mediaId);
                    perParam.setTotalCount(totalCount);
                    perParams.add(perParam);
                }
                List<MaterialReturn> newsReturn = getMaterialByMediaId(perParams, accessToken);
                lists.addAll(newsReturn);
                return lists;
            } catch (JSONException e) {
                // 获取Material失败
                log.error("获取Material失败 errcode:{} errmsg:{}", jsonObject.getIntValue("errcode"), jsonObject.getString("errmsg"));
            }
        }
        return lists;
    }


    /**根据
     * @see com.example.weixingapi.utils
     * 中  getMaterial() 获取 media_id
     * 通过 media_id 获取图文组件信息
     * @Parm perParam  内部封装的传参
     * @Parm accessToken
     * */
    private static List<MaterialReturn> getMaterialByMediaId(List<PerParam> perParams, String accessToken) {

        List<MaterialReturn> newsReturns = new ArrayList<>();

        //替换调access_token
        String requestUrl = MATERIALBYMEDIAID.replace("ACCESS_TOKEN", accessToken);
        //调用接口所需要的参数实体类
        perParams.forEach(perParam-> {
            //将参数对象转换成json字符串
            String outputStr = "{"+
                    '\"'+"media_id"+'\"' + ":" +'\"'+perParam.getMediaId() + '\"'
                    +"}" ;
            //发送https请求(请求的路径,方式,所携带的参数)
            JSONObject jsonObject = httpsRequest(requestUrl, "POST", outputStr);
            // 如果请求成功
            if (null != jsonObject) {
                try {
                    JSONArray newsItemArray = jsonObject.getJSONArray("news_item");
                    if(null == newsItemArray || newsItemArray.isEmpty()){
                        log.info("微信公众号返回数据为空！");
                        return ;
                    }
                    for (int i = 0; i < newsItemArray.size(); i++) {
                        JSONObject itemJson = (JSONObject) newsItemArray.get(i);
                        //图文类型返回
                        MaterialReturn news = new MaterialReturn();
                        String title = itemJson.getString("title");
                        String thumbMediaId = itemJson.getString("thumb_media_id");
                        Integer showCoverPic = itemJson.getIntValue("show_cover_pic");
                        String author = itemJson.getString("author");
                        String digest = itemJson.getString("digest");
                        String content = itemJson.getString("content");
                        String url = itemJson.getString("url");
                        String thumbUrl = itemJson.getString("thumb_url");
                        String contentSourceUrl = itemJson.getString("content_source_url");
                        //组装 app 轮播图展示信息
                        news.setTitle(title);
                        news.setAuthor(author);
                        news.setDigest(digest);
                        news.setThumbMediaId(thumbMediaId);
                        news.setThumbUrl(thumbUrl);
                        news.setUrl(url);
                        news.setContent(content);
                        news.setShowCoverPic(showCoverPic);
                        news.setContentSourceUrl(contentSourceUrl);
                        news.setUpdateTime(perParam.getUpdateTime());
                        news.setTotalCount(perParam.getTotalCount());
                        newsReturns.add(news);
                    }
                } catch (JSONException e) {
                    // 获取Material失败
                    log.error("获取Material失败 errcode:{} errmsg:{}", jsonObject.getIntValue("errcode"), jsonObject.getString("errmsg"));
                }
            }
        });
        return newsReturns;
    }



    /**
     * @method  timestamToDatetime
     * @description 时间错转化为 date
     * @date: 2019/5/22 0022 15:01
     * @author: mdengb
     * @param timestamp 微信返回的时间戳 是间隔的秒数   需转换为毫秒数
     * @return
     */
    private static Date timestamToDatetime(long timestamp){
        //微信返回的时间戳 是间隔的秒数   需转换为毫秒数
        Instant instant = Instant.ofEpochMilli(timestamp*1000L);
        return DateUtils.localDateTime2Date(LocalDateTime.ofInstant(instant, ZoneId.systemDefault()));
    }

}
