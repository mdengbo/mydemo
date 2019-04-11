package com.example.demo;

import com.example.demo.entity.Almanac;
import com.example.demo.entity.NewsManagementSaveDTO;
import com.example.demo.utils.AlmanacUtil;
import com.example.demo.utils.HttpClientUtil;
import lombok.extern.slf4j.Slf4j;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import java.util.*;

@RunWith(SpringRunner.class)
@SpringBootTest
@Slf4j
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

	@Test
	public void Reverse(){
		List<Integer> ls = new ArrayList<>();
		for(int i=0 ; i<=5; i++){
			ls.add(i);
		}
		for (Integer o: ls ) {
			log.info("first: {}",o);
		}
		Collections.reverse(ls);
		for (Integer o: ls ) {
			log.info("after: {}",o);
		}
	}
    @Test
    public void saveByReptilian() {

    //获取最后一个新闻抓取时间
    Calendar beforeTime = Calendar.getInstance();
    beforeTime.add(Calendar.DATE, -5);// 前三天时间
    Date date = beforeTime.getTime();

    //执行抓取
    List<NewsManagementSaveDTO> list = HttpClientUtil.findIndexInit(date);
    date = new Date();

    }
}

