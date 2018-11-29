package com.example.easypoiexcel.entity;

import cn.afterturn.easypoi.excel.annotation.Excel;

import java.util.Date;

/**
 * @author madengbo
 * @create 2018-11-29 18:03
 * @desc
 * @Version 1.0
 **/
public class AppAndFile {

    @Excel(name = "应用Id", height = 20, width = 30, isImportField = "true",  orderNum = "6", mergeVertical = true)
    private String appId;

    @Excel(name = "应用名称", height = 20, width = 30, isImportField = "true",  orderNum = "5", mergeVertical = true)
    private String appName;


    @Excel(name = "文件类型", height = 20, width = 30, orderNum = "4", isImportField = "true")
    private String type;

    /**
     * replace = { "视频_VIDEO", "文档_DOC" } 表示：将 video 替换为 视频， DOC 替换为 文档
     *
     * */
    @Excel(name = "数据类型", height = 20, width = 30, orderNum = "3", replace = { "图片_IMAGE", "文档_DOC" }, isImportField = "true")
    private String dataType;

    @Excel(name = "数量", height = 20, width = 30, orderNum = "2", isImportField = "true")
    private String num;

    /**
     * groupName 可分组 把名字相同的合为一组 形成多级目录
     * */

    @Excel(name = "出生日期",  isImportField = "true", width = 20)
    private String fyearMonth;

    @Excel(name = "统计时间",  isImportField = "false", width = 20)
    private String createTime;


    public String getAppId() {
        return appId;
    }

    public void setAppId(String appId) {
        this.appId = appId == null ? null : appId.trim();
    }

    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type == null ? null : type.trim();
    }

    public String getDataType() {
        return dataType;
    }

    public void setDataType(String dataType) {
        this.dataType = dataType == null ? null : dataType.trim();
    }

    public String getNum() {
        return num;
    }

    public void setNum(String num) {
        this.num = num == null ? null : num.trim();
    }

    public String getFyearMonth() {
        return fyearMonth;
    }

    public void setFyearMonth(String fyearMonth) {
        this.fyearMonth = fyearMonth == null ? null : fyearMonth.trim();
    }

    public String getCreateTime() {
        return createTime;
    }

    public void setCreateTime(String createTime) {
        this.createTime = createTime;
    }

    public String getAppName() {
        return appName;
    }

    public void setAppName(String appName) {
        this.appName = appName;
    }
}
