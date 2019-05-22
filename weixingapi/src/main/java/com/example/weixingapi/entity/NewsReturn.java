package com.example.weixingapi.entity;

import lombok.Data;

import java.util.Date;

/**
 * @author madengbo
 * @create 2019-05-22 11:10
 * @desc 图文类型 素材返回
 * @Version 1.0
 **/
@Data
public class NewsReturn extends MaterialReturn{
    /**
     * 图文消息的标题
     * */
    private String title;
    /**
     *图文消息的封面图片素材id（必须是永久mediaID）
     * */
    private String thumbMediaId;
    /**
     *作者
     * */
    private String author;
    /**
     *图文消息的摘要，仅有单图文消息才有摘要，多图文此处为空
     * */
    private String digest;
    /**
     *图文消息的具体内容，支持HTML标签，必须少于2万字符，小于1M，且此处会去除JS
     * */
    private String content;
    /**
     *图文页的URL，或者，当获取的列表是图片素材列表时，该字段是图片的URL
     * */
    private String url;
    /**
     *是否显示封面，0为false，即不显示，1为true，即显示
     * */
    private int showCoverPic;
    /**
     *封面图片 url
     * */
    private String thumbUrl;

    private Date updateTime;
}
