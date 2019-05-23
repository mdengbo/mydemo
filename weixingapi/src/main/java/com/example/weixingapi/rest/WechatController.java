package com.example.weixingapi.rest;

import com.example.weixingapi.entity.MaterialParam;
import com.example.weixingapi.entity.MaterialReturn;
import com.example.weixingapi.entity.MaterialTypeEnum;
import com.example.weixingapi.entity.TokenParam;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.data.redis.core.RedisTemplate;
import org.springframework.data.redis.core.ValueOperations;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;
import java.util.concurrent.TimeUnit;

/**
 * @author madengbo
 * @create 2019-05-22 09:47
 * @desc 微信公众号 api
 * @Version 1.0
 **/
@RestController
@Slf4j
@RequestMapping("/wechat")
public class WechatController {
    /**
     * appId
     * */
    @Value("${mydemo.wechat.appId}")
    private String appId;
    /**
     * appSecret
     * */
    @Value("${mydemo.wechat.appSecret}")
    private String  appSecret;

    @Autowired
    private RedisTemplate<String,String> redisTemplate;

    private String redisAccessTokenKey = "wechat_access_token";
    /**
     * 通过公众号 获取素材资料
     *
     * @param materialParam
     * @return
     */
    @RequestMapping(value = "/get/material", method = RequestMethod.POST)
    public List<MaterialReturn> getMaterial(@RequestBody MaterialParam materialParam) {

        log.info("appId:{}",appId);
        log.info("appSecret:{}",appSecret);
        ValueOperations valueOperations = redisTemplate.opsForValue();
        Object mapObj = valueOperations.get(redisAccessTokenKey);
        String accessToken = (String)mapObj;
        TokenParam token = null;
       if(null == accessToken){
           token = com.hengyunsoft.platform.biz.util.WechatUtil.getToken(appId, appSecret);
           accessToken = token.getAccessToken();
           //通过redis 保存 accessToken 并设置定时 2 小时 失效（因为微信 accessToken  每次生成时 2h 内有效）
           valueOperations.set(redisAccessTokenKey, accessToken, 2*60*60 , TimeUnit.SECONDS);
           int expiresIn = token.getExpiresIn();
           log.info("expires_in: {}",expiresIn);
       }
        log.info("access_token: {}",accessToken);
        //默认获取 图文 news
        if(null == materialParam.getType()){
            materialParam.setType(MaterialTypeEnum.NEWS.getCode());
        }
        //图片（image）、视频（video）、语音 （voice）、图文（news）
        List<MaterialReturn> image = com.hengyunsoft.platform.biz.util.WechatUtil.getMaterial(accessToken, materialParam);
        log.info("image:{}",image.size());
        //2.验证并返回
        return image;
    }



}
