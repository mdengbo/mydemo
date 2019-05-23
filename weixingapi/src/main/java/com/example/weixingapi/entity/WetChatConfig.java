package com.example.weixingapi.entity;

/**
 * @date: 2019/5/23 0023 10:38
 * @author: mdengb
 * @return
 */
public enum WetChatConfig {
    /**
    * appId
    * */
    APP_ID("wx85fxxx9f73653dssf1326ac","WetchatConfig appId"),
    /**
     * appSecret
    * */
    APP_SECRET("a18e8ba2040xxxxb66932009ss53e47f0c1c40d52","WetchatConfig APP_SECRET");
    private String data;
    private String desc;

    WetChatConfig() {
    }

    WetChatConfig(String data) {
        this.data = data;
    }

    WetChatConfig(String data, String desc) {
        this.data = data;
        this.desc = desc;
    }

    public String getData() {
        return data;
    }

    public void setData(String data) {
        this.data = data;
    }

    public String getDesc() {
        return desc;
    }

    public void setDesc(String desc) {
        this.desc = desc;
    }
}
