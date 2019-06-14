package com.example.jdk8lambda;

import lombok.extern.slf4j.Slf4j;
import org.assertj.core.util.Lists;
import org.junit.Assert;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import java.util.*;
import java.util.function.Predicate;
import java.util.stream.Collectors;
import java.util.stream.Stream;

import static org.hamcrest.core.IsEqual.equalTo;

@RunWith(SpringRunner.class)
@SpringBootTest
@Slf4j
public class optionalTests {

	@Test
	public void contextLoads() {
	}

	@Test
	public  void testOption(){
		List<Human> humans = Lists.newArrayList(
				new Human("zd", 0), new Human("", 0), new Human("Zack", 12));
		//Optional 只是做null判断  需保证表达式有值返回
		String ret = Optional.ofNullable(humans)
				.filter(a->a.get(0).getName()=="zd") //条件筛选 过滤 值成立 往下执行
				.map(a -> a.get(0).getName())  //map相当于 判断 if 并返回后面（）表达式 的值 orElse 为判断途中出问题 返回的值  每一个map的执行后的值 就是后一个map 的条件
				.map(a -> humans.get(1).getName())
				.map(a -> humans.get(1).setName("重新赋值：zs001"))
				.map(a -> humans.get(1).setAge(15))
				.map(a -> humans.get(1).toString())
				.orElse("错了");
		log.info("ret->:{}",ret);
	}



}
