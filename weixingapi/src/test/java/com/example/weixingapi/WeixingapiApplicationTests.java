package com.example.weixingapi;

import com.example.weixingapi.entity.MaterialParam;
import com.example.weixingapi.entity.MaterialReturn;
import com.example.weixingapi.entity.TokenParam;
import com.example.weixingapi.entity.WetChatConfig;
import com.example.weixingapi.utils.WechatUtil;
import lombok.extern.slf4j.Slf4j;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import javax.net.ssl.SSLContext;
import javax.net.ssl.SSLSocket;
import javax.net.ssl.SSLSocketFactory;
import java.io.IOException;
import java.security.KeyManagementException;
import java.security.NoSuchAlgorithmException;
import java.util.List;

@RunWith(SpringRunner.class)
@SpringBootTest
@Slf4j
public class WeixingapiApplicationTests {


	@Test
	public void contextLoads() {
		//其中的WeChatConfig方法中有定义的自己微信公众号的appid和appsecret值 用到时直接调用
		TokenParam token = WechatUtil.getToken(WetChatConfig.APP_ID.getData(), WetChatConfig.APP_SECRET.getData());
		log.info("access_token:"+token.getAccessToken());
		log.info("expires_in:"+token.getExpiresIn());
	}

	@Test
	public void getMaterial() {
		TokenParam token = WechatUtil.getToken(WetChatConfig.APP_ID.getData(), WetChatConfig.APP_SECRET.getData());
        String accessToken = token.getAccessToken();
        //可以 考虑 redis 保存accessToken  因为微信对于请求调用有限制  对accessToken 的调用又有所 控制
        int expiresIn = token.getExpiresIn();
        log.info("access_token: {}",accessToken);
		log.info("expires_in: {}",expiresIn);
		MaterialParam materialParam = new MaterialParam();
		//图片（image）、视频（video）、语音 （voice）、图文（news）
		materialParam.setType("news");
		materialParam.setOffset(0);
		materialParam.setCount(10);
        List<MaterialReturn> image = WechatUtil.getMaterial(accessToken, materialParam);
		//因为获取中含有 为发布的信息   所以需要过滤掉  保证 获取一组数据返回
		while (image.isEmpty()){
			materialParam.setOffset(materialParam.getOffset() + 1);
			image = WechatUtil.getMaterial(accessToken, materialParam);
		}
        log.info("image:{}",image.size());
    }
    //本地 tls 协议支持测试
	@Test
	public  void test10(){

		try {
			SSLContext context = SSLContext.getInstance("TLS");
			context.init(null, null, null);

			SSLSocketFactory factory = (SSLSocketFactory) context.getSocketFactory();
			SSLSocket socket = null;
			socket = (SSLSocket) factory.createSocket();
			String[] protocols = socket.getSupportedProtocols();

			System.out.println("Supported Protocols: " + protocols.length);
			for (int i = 0; i < protocols.length; i++) {
				System.out.println(" " + protocols[i]);
			}

			protocols = socket.getEnabledProtocols();

			System.out.println("Enabled Protocols: " + protocols.length);
			for (int i = 0; i < protocols.length; i++) {
				System.out.println(" " + protocols[i]);
			}
		} catch (Exception e) {
			e.printStackTrace();
		}



	}
}
