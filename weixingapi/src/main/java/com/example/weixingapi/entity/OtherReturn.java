package com.example.weixingapi.entity;

import lombok.Data;

import java.util.Date;

/**
 * @author madengbo
 * @create 2019-05-22 10:34
 * @desc 其他类型（图片、语音、视频）的返回 实体
 * @Version 1.0
 **/
@Data
public class OtherReturn{

    /**
     *图文消息的封面图片素材id（必须是永久mediaID）
     * */
    private String mediaId;

    /**
     *文件名称
     * */
    private String name;

    /**
     *图文页的URL，或者，当获取的列表是图片素材列表时，该字段是图片的URL
     * */
    private String url;

    /**
     *该类素材总数量
     * */
    private Integer totalCount;

    /**
     *这篇图文消息素材的最后更新时间
     * */
    private Date updateTime;
}
