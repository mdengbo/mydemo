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
public class Jdk8lambdaApplicationTests {

	@Test
	public void contextLoads() {
	}
	/**
	 * 循环取值
	 * */
	@Test
	public  void test(){
	List<Integer> list = new ArrayList<>();
		list.add(1);
		list.add(2);
		list.add(3);
		list.forEach(System.out::println);
		// 取值分别操作
		list.forEach(i -> {
		System.out.println(i * 3);
		});
	}

	/**
	 *
	 * */
	@Test
	public  void test01(){
		List<String> languages = Arrays.asList("Java", "Scala", "C++", "Haskell", "Lisp");

		System.out.println("Languages which starts with J :");
		filter(languages, (str) -> ((String) str).startsWith("J"));

		System.out.println("Languages which ends with a ");
		filter(languages, (str) -> ((String) str).endsWith("a"));

		System.out.println("Print all languages :");
		filter(languages, (str) -> true);

		System.out.println("Print no language : ");
		filter(languages, (str) -> false);

		System.out.println("Print language whose length greater than 4:");
		filter(languages, (str) -> ((String) str).length() > 4);

	}
	/**
	 * Predicate 该接口除了test方法是抽象方法, 其余都是default方法, 该接口可接受一个 lambda表达式, 其实就是实现了test接口的一个匿名类
	 * */
	public static void filter(List<String> names, Predicate condition) {
		for (String name : names) {
			if (condition.test(name)) {
				System.out.println(name + " ");
			}
		}
	}

	@Test
	public void test02() {
		Predicate<String> startWithJ = (n) -> n.startsWith("J");
		Predicate<String> fourLength = (n) -> n.length() == 4;

		List<String> languages = Arrays.asList("Java", "Scala", "C++", "Haskell", "Lisp");
		languages.stream().filter(startWithJ.and(fourLength))
				.forEach(System.out::println);
	}

	@Test
	public void test03() {
		List<Integer> list = new ArrayList<>();
		list.add(1);
		list.add(2);
		list.add(3);

		// 可改变对象
		list.stream().map((i) -> i * 3).forEach(System.out::println);

		// 不可改变元有对象
		list.forEach(i -> i = i * 3);
		list.forEach(System.out::println);


	}

	@Test
	public void test04() {
		List<Integer> primes = Arrays.asList(2, 3, 5, 7, 11, 13, 17, 19, 23, 29);
		IntSummaryStatistics stats = primes.stream().mapToInt((x) -> x)
				.summaryStatistics();
		/**
		* */
		System.out.println("Highest prime number in List : " + stats.getMax());
		System.out.println("Lowest prime number in List : " + stats.getMin());
		System.out.println("Sum of all prime numbers : " + stats.getSum());
		System.out.println("Average of all prime numbers : " + stats.getAverage());
	}

	@Test
	public void test05(){
	Stream<List<Integer>> inputStream = Stream.of(
			Arrays.asList(1),
			Arrays.asList(2, 3),
			Arrays.asList(4, 5, 6)
	);
	Stream<Integer> outputStream = inputStream.
			flatMap((childList) -> childList.stream());

		outputStream.forEach(System.out::println);
	}

	@Test
	public void test06() {
		List<Integer> list = new ArrayList<>();
		list.add(1);
		list.add(2);
		list.add(3);

		Integer integer = list.stream().map((i) -> i = i * 3)
				.reduce((sum, count) -> sum += count).get();

		System.out.println(integer);
	}

	@Test
	public void test07() {
		// 字符串连接，concat = "ABCD"
		String concat = Stream.of("A", "B", "C", "D").reduce("", String::concat);
		log.info("concat: {}",concat);
		// 求最小值，minValue = -3.0
		double minValue = Stream.of(-1.5, 1.0, -3.0, -2.0).reduce(Double.MAX_VALUE, Double::min);
		log.info("minValue: {}",minValue);
		// 求和，sumValue = 10, 有起始值
		int sumValue = Stream.of(1, 2, 3, 4).reduce(0, Integer::sum);
		log.info("sumValue: {}",sumValue);
		// 求和，sumValue = 10, 无起始值
		sumValue = Stream.of(1, 2, 3, 4).reduce(Integer::sum).get();
		log.info("sumValue: {}",sumValue);
		// 过滤，字符串连接，concat = identity +"ace"  拼接
		concat = Stream.of("a", "B", "c", "D", "e", "F").
				filter(x -> x.compareTo("Z") > 0).
				reduce("", String::concat);
		log.info("concat: {}",concat);
	}
	/**
	 * 去重
	 * */
	@Test
	public void test08() {
		List<Integer> numbers = Arrays.asList(9, 10, 3, 4, 7, 3, 4);
		List<Integer> distinct = numbers.stream().distinct().collect(Collectors.toList());
		distinct.forEach(System.out::println);
	}

	@Test
	public void givenComposition_whenSortingEntitiesByNameThenAge_thenCorrectlySorted() {
		List<Human> humans = Lists.newArrayList(
				new Human("Sarah", 12), new Human("Sarah", 10), new Human("Zack", 12));
		humans.sort(Comparator.comparing(Human::getName).thenComparing(Human::getAge));
		Assert.assertThat(humans.get(0), equalTo(new Human("Sarah", 10)));
		humans.forEach(System.out::println);
		log.info("------------------------------");
		humans.stream().filter(x -> x.getAge() > 11).forEach(System.out::println);
	}
}
