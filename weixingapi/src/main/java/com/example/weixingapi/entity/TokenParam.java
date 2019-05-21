package com.example.weixingapi.entity;

import lombok.Data;

/**
 * @author madengbo
 * @create 2019-05-21 17:25
 * @desc token 参数
 * @Version 1.0
 **/
@Data
public class TokenParam {
    /**
     *  接口访问凭证
     * */
    private String accessToken;
    /**
     *  凭证有效期，单位：秒
     * */
    private int expiresIn;
}
