package com.example.demo;

import com.example.demo.entity.Almanac;
import com.example.demo.utils.AlmanacUtil;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

@RunWith(SpringRunner.class)
@SpringBootTest
public class DemoApplicationTests {

	@Test
	public void contextLoads() {
	}

	@Test
	public void AlmanacUtilTest() {
		Almanac almanac= AlmanacUtil.getAlmanac();
		System.out.println("公历时间："+almanac.getSolar());
		System.out.println("农历时间："+almanac.getLunar());
		System.out.println("天干地支："+almanac.getChineseAra());
		System.out.println("宜："+almanac.getShould());
		System.out.println("忌："+almanac.getAvoid());
	}


}

