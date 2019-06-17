package com.example.weixingapi.entity;

import lombok.Data;

import java.util.Date;

/**
 * @author madengbo
 * @create 2019-05-22 11:10
 * @desc 人永久素材 传参列表
 * @Version 1.0
 **/
@Data
public class PerParam{

    /**
     *组件 mediaIds
     * */
    private String mediaId;
    /**
     *文章最后更新时间
     * */
    private Date updateTime;
    /**
     *列表总数
     * */
    private Integer totalCount;

}
