package com.example.weixingapi.entity;

/**
 * 微信素材枚举
 *
 * @author madengbo
 * @date 2019-05-22
 */
public enum MaterialTypeEnum {

    //图片（image）、视频（video）、语音 （voice）、图文（news）
    IMAGE("image", "图片类型"),
    VIDEO("video", "视频类型"),
    VOICE("voice", "语音类型"),
    NEWS("news", "图文类型")
    ;
    private String code;
    private String des;

    public String getCode() {
        return code;
    }

    public String getTitle() {
        return des;
    }

    MaterialTypeEnum(String code, String des) {
        this.code = code;
        this.des = des;
    }

    public boolean eq(String code) {
        if(code != null && code == this.code){
            return true;
        }
        return false;
    }
}
