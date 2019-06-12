package com.example.enumdemo;

import com.example.enumdemo.EnumDemo.AppEnumWork;
import com.example.enumdemo.EnumSingleton.EnumSingleton;
import com.example.enumdemo.EnumSingleton.StaticInitTest;
import lombok.extern.slf4j.Slf4j;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

@RunWith(SpringRunner.class)
@SpringBootTest
@Slf4j
public class EnumdemoApplicationTests {

	@Test
	public void contextLoads() {
		EnumSingleton obj1 = EnumSingleton.getInstance();
		EnumSingleton obj2 = EnumSingleton.getInstance();
		//输出结果：obj1==obj2?true
		System.out.println("obj1==obj2 ? --->" + (obj1==obj2));
	}

	@Test
	public void test() {
		StaticInitTest obj1 =  new StaticInitTest();
		StaticInitTest obj2 =  new StaticInitTest();
		//输出结果：obj1==obj2?true
		System.out.println("obj1==obj2 ? --->" + (obj1==obj2));
	}

	@Test
	public void testEnumDemo(){

		AppEnumWork.business.setWorkInfo("business");
		log.info("----------");
		AppEnumWork.valueOf("business").setWorkInfo("lalalalal");
		AppEnumWork[] businesses = AppEnumWork.values();
		log.info("businesses：{}",businesses[0]);

	}


}
