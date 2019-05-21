package com.example.weixingapi.entity;

public enum WetChatConfig {
    APP_ID("wx85f9f73653df16ac","WetchatConfig appId"),
    APP_SECRET("a18e8ba2040b6690095e47f0c1c40d52","WetchatConfig APP_SECRET");
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
