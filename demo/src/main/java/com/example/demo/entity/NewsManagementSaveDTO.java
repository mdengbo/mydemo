package com.example.demo.entity;

import lombok.Data;

import java.util.Date;

/**
 * 查询新闻管理列表实体
 * @author farglory
 * @date 2018年9月29日 下午4:38:53
 */
@Data
public class NewsManagementSaveDTO {
	/**
     * 主键
     *
     * @mbggenerated
     */
    private Long id;
    
    /**
     * 新闻标题
     *
     * @mbggenerated
     */
    private String newsTitle;
    /**
     * 发表人名称
     *
     * @mbggenerated
     */
    private String postedByName;

    /**
     * 原发布时间
     *
     * @mbggenerated
     */
    private Date publicationTime;
    

    /**
     * 显示标志
     *
     * @mbggenerated
     */
    private Integer displaySign;
    
    /**
     * 新闻类型
     *
     * @mbggenerated
     */
    private String newsType;
    
    /**
     * 获取方式
     *
     * @mbggenerated
     */
    private Integer obtainType;
    
    /**
     * 新闻来源
     *
     * @mbggenerated
     */
    private String newsSource;

    /**
     * 新闻小图标
     *
     * @mbggenerated
     */
    private String newsSmallIcon;

    /**
     * 新闻大图标
     *
     * @mbggenerated
     */
    private String newsBigIcon;

    /**
     * 来源网址
     *
     * @mbggenerated
     */
    private String sourceUrl;

    /**
     * 新闻内容
     *
     * @mbggenerated
     */
    private String newsContent;

    private static final long serialVersionUID = 1L;

}