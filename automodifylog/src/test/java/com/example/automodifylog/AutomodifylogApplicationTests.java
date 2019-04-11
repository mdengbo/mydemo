package com.example.automodifylog;

import com.example.automodifylog.uitils.pinyin.Pinyin4jUtil;
import com.example.automodifylog.uitils.pinyin.PinyinHelper;
import lombok.extern.slf4j.Slf4j;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

@RunWith(SpringRunner.class)
@SpringBootTest
@Slf4j
public class AutomodifylogApplicationTests {

	@Test
	public void contextLoads() {
        String headChar = Pinyin4jUtil.getSimplePinyinHeadChar("呃嗯嗯嗯中国人");
        String aChar = Pinyin4jUtil.getPinYinHeadChar("中国人");
        String aChar1 = PinyinHelper.getHeadCharToUpperCase("中国人");
        String aChar2 = PinyinHelper.getPinYinHeadCharToUpperCase("哎呃恩");
        String aChar3 = Pinyin4jUtil.getSimplePinyinHeadChar("日本人中国人");
        log.info("headChar: {}", headChar.toUpperCase());
        log.info("aChar: {}", aChar);
        log.info("aChar1: {}", aChar1);
        log.info("aChar2: {}", aChar2);
        log.info("aChar3: {}", aChar3);
    }

}
