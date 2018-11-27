package com.example.easypoiexcel.entity;

import cn.afterturn.easypoi.excel.annotation.Excel;
import cn.afterturn.easypoi.excel.annotation.ExcelCollection;
import cn.afterturn.easypoi.excel.annotation.ExcelTarget;

import java.io.Serializable;
import java.util.Date;
import java.util.List;

@ExcelTarget("Application")
public class Application implements Serializable {
    private Long id;

    @Excel(name = "应用Id", orderNum = "1",needMerge = true)
    private String appId;

    private String appSecret;

    private String indexUrl;

    @Excel(name = "应用名称", orderNum = "1")
    private String name;

    private String logoUrl;

    private String desc;

    private String code;

    private Integer orderNo;

    private Short appType;

    private String type;

    private String provider;

    private Boolean status;

    private String randomStr;

    private Long createUser;

    private Date createTime;

    private Long updateUser;

    private Date updateTime;

    private String orgId;

    private String orgSystemCode;

    private String orgName;

    private Double reduceTime;

    private Integer reduceCost;

    private Double originalTime;

    private Integer originalCost;

    private String isFastApp;

    private Long bizConfigId;

    private Integer hotsCount;

    private Integer reduceBuildCost;

    private Integer reduceUseCost;

    private Integer reduceProtectCost;

    private Boolean publicIs;

    private String serviceId;

    private String fullRootPath;



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

    public String getAppSecret() {
        return appSecret;
    }

    public void setAppSecret(String appSecret) {
        this.appSecret = appSecret == null ? null : appSecret.trim();
    }

    public String getIndexUrl() {
        return indexUrl;
    }

    public void setIndexUrl(String indexUrl) {
        this.indexUrl = indexUrl == null ? null : indexUrl.trim();
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name == null ? null : name.trim();
    }

    public String getLogoUrl() {
        return logoUrl;
    }

    public void setLogoUrl(String logoUrl) {
        this.logoUrl = logoUrl == null ? null : logoUrl.trim();
    }

    public String getDesc() {
        return desc;
    }

    public void setDesc(String desc) {
        this.desc = desc == null ? null : desc.trim();
    }

    public String getCode() {
        return code;
    }

    public void setCode(String code) {
        this.code = code == null ? null : code.trim();
    }

    public Integer getOrderNo() {
        return orderNo;
    }

    public void setOrderNo(Integer orderNo) {
        this.orderNo = orderNo;
    }

    public Short getAppType() {
        return appType;
    }

    public void setAppType(Short appType) {
        this.appType = appType;
    }

    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type == null ? null : type.trim();
    }

    public String getProvider() {
        return provider;
    }

    public void setProvider(String provider) {
        this.provider = provider == null ? null : provider.trim();
    }

    public Boolean getStatus() {
        return status;
    }

    public void setStatus(Boolean status) {
        this.status = status;
    }

    public String getRandomStr() {
        return randomStr;
    }

    public void setRandomStr(String randomStr) {
        this.randomStr = randomStr == null ? null : randomStr.trim();
    }

    public Long getCreateUser() {
        return createUser;
    }

    public void setCreateUser(Long createUser) {
        this.createUser = createUser;
    }

    public Date getCreateTime() {
        return createTime;
    }

    public void setCreateTime(Date createTime) {
        this.createTime = createTime;
    }

    public Long getUpdateUser() {
        return updateUser;
    }

    public void setUpdateUser(Long updateUser) {
        this.updateUser = updateUser;
    }

    public Date getUpdateTime() {
        return updateTime;
    }

    public void setUpdateTime(Date updateTime) {
        this.updateTime = updateTime;
    }

    public String getOrgId() {
        return orgId;
    }

    public void setOrgId(String orgId) {
        this.orgId = orgId == null ? null : orgId.trim();
    }

    public String getOrgSystemCode() {
        return orgSystemCode;
    }

    public void setOrgSystemCode(String orgSystemCode) {
        this.orgSystemCode = orgSystemCode == null ? null : orgSystemCode.trim();
    }

    public String getOrgName() {
        return orgName;
    }

    public void setOrgName(String orgName) {
        this.orgName = orgName == null ? null : orgName.trim();
    }

    public Double getReduceTime() {
        return reduceTime;
    }

    public void setReduceTime(Double reduceTime) {
        this.reduceTime = reduceTime;
    }

    public Integer getReduceCost() {
        return reduceCost;
    }

    public void setReduceCost(Integer reduceCost) {
        this.reduceCost = reduceCost;
    }

    public Double getOriginalTime() {
        return originalTime;
    }

    public void setOriginalTime(Double originalTime) {
        this.originalTime = originalTime;
    }

    public Integer getOriginalCost() {
        return originalCost;
    }

    public void setOriginalCost(Integer originalCost) {
        this.originalCost = originalCost;
    }

    public String getIsFastApp() {
        return isFastApp;
    }

    public void setIsFastApp(String isFastApp) {
        this.isFastApp = isFastApp == null ? null : isFastApp.trim();
    }

    public Long getBizConfigId() {
        return bizConfigId;
    }

    public void setBizConfigId(Long bizConfigId) {
        this.bizConfigId = bizConfigId;
    }

    public Integer getHotsCount() {
        return hotsCount;
    }

    public void setHotsCount(Integer hotsCount) {
        this.hotsCount = hotsCount;
    }

    public Integer getReduceBuildCost() {
        return reduceBuildCost;
    }

    public void setReduceBuildCost(Integer reduceBuildCost) {
        this.reduceBuildCost = reduceBuildCost;
    }

    public Integer getReduceUseCost() {
        return reduceUseCost;
    }

    public void setReduceUseCost(Integer reduceUseCost) {
        this.reduceUseCost = reduceUseCost;
    }

    public Integer getReduceProtectCost() {
        return reduceProtectCost;
    }

    public void setReduceProtectCost(Integer reduceProtectCost) {
        this.reduceProtectCost = reduceProtectCost;
    }

    public Boolean getPublicIs() {
        return publicIs;
    }

    public void setPublicIs(Boolean publicIs) {
        this.publicIs = publicIs;
    }

    public String getServiceId() {
        return serviceId;
    }

    public void setServiceId(String serviceId) {
        this.serviceId = serviceId == null ? null : serviceId.trim();
    }

    public String getFullRootPath() {
        return fullRootPath;
    }

    public void setFullRootPath(String fullRootPath) {
        this.fullRootPath = fullRootPath == null ? null : fullRootPath.trim();
    }
}