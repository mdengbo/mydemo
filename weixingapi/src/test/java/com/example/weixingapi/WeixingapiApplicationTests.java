package com.example.weixingapi;

import com.example.weixingapi.Utils.CommonUtil;
import com.example.weixingapi.entity.MaterialReturn;
import com.example.weixingapi.entity.TokenParam;
import com.example.weixingapi.entity.WetChatConfig;
import lombok.extern.slf4j.Slf4j;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import java.util.List;

@RunWith(SpringRunner.class)
@SpringBootTest
@Slf4j
public class WeixingapiApplicationTests {


	@Test
	public void contextLoads() {
		//其中的WeChatConfig方法中有定义的自己微信公众号的appid和appsecret值 用到时直接调用
		TokenParam token = CommonUtil.getToken(WetChatConfig.APP_ID.getData(), WetChatConfig.APP_SECRET.getData());
		log.info("access_token:"+token.getAccessToken());
		log.info("expires_in:"+token.getExpiresIn());
	}

	@Test
	public void getMaterial() {
		TokenParam token = CommonUtil.getToken(WetChatConfig.APP_ID.getData(), WetChatConfig.APP_SECRET.getData());
        String accessToken = token.getAccessToken();
        int expiresIn = token.getExpiresIn();
        log.info("access_token: {}",accessToken);
		log.info("expires_in: {}",expiresIn);
		//图片（image）、视频（video）、语音 （voice）、图文（news）
        List<MaterialReturn> image = CommonUtil.getMaterial(accessToken, "news", 0, 10);
        log.info("image:{}",image.size());
    }
}
