package com.example.easypoiexcel.entity;

import cn.afterturn.easypoi.excel.annotation.Excel;
import cn.afterturn.easypoi.excel.annotation.ExcelTarget;

import java.io.Serializable;
import java.util.Date;

@SuppressWarnings("serial")
@ExcelTarget("FileUserNum")
public class FileUserNum implements Serializable {

    private Long id;

    @Excel(name = "应用Id", height = 20, width = 30, isImportField = "true",  orderNum = "1")
    private String appId;

    @Excel(name = "文件类型", height = 20, width = 30, isImportField = "true")
    private String type;

    /**
     * replace = { "视频_VIDEO", "文档_DOC" } 表示：将 video 替换为 视频， DOC 替换为 文档
     *
     * */
    @Excel(name = "数据类型", height = 20, width = 30, replace = { "视频_VIDEO", "文档_DOC" }, isImportField = "true")
    private String dataType;

    @Excel(name = "数量", height = 20, width = 30, isImportField = "true")
    private String num;

    /**
     * groupName 可分组 把名字相同的合为一组 形成多级目录
     * */

    @Excel(name = "出生日期", databaseFormat = "yyyy-MM", format = "yyyy/MM", isImportField = "true", width = 20)
    private String fyearMonth;

    @Excel(name = "统计时间", databaseFormat = "yyyy-MM-dd HH:mm:ss", format = "yyyy-MM-dd", isImportField = "false", width = 20)
    private Date createTime;

    private Long createUser;

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

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

    public Date getCreateTime() {
        return createTime;
    }

    public void setCreateTime(Date createTime) {
        this.createTime = createTime;
    }

    public Long getCreateUser() {
        return createUser;
    }

    public void setCreateUser(Long createUser) {
        this.createUser = createUser;
    }
}