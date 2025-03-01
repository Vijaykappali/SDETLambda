package com.udemy.java.supplier;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.function.BiConsumer;
import java.util.function.Consumer;

public class TestMain4_Consumer {

	public static void main(String[] args) {
		// TODO Auto-generated method stub

		Consumer<String> c = (s) -> System.out.println(s);

		// c.accept("vijay");

		List<String> list = new ArrayList();
		list.add("abcd");
		list.add("efgh");
		list.add("ijkl");

		// list.forEach(c);

		// list.forEach(s -> System.out.println(s));

		// list.forEach(s -> System.out.println(s.toUpperCase()));

		Consumer<String> insertToDB = (s) -> {
			System.out.println("insert into DB - " + s);
		};
		// list.forEach(insertToDB);

		Consumer<String> insertToLogFile = (s) -> {
			System.out.println("insert into logfile - " + s);
		};
//		list.forEach(insertToLogFile);

		Consumer<String> dbLogBothConsumer = insertToDB.andThen(insertToLogFile);
//		list.forEach(dbLogBothConsumer);

		Map<String, Consumer<String>> map = new HashMap();
		map.put("db", insertToDB);
		map.put("log", insertToLogFile);
		map.put("dblog", dbLogBothConsumer);

//		list.forEach(map.get("db"));
//		list.forEach(map.get("log"));
//		list.forEach(map.get("dblog"));

		biConsumerSample();
	}

	static void biConsumerSample() {

		BiConsumer<String, Integer> biConsumer = (s, i) -> {
			System.out.println("Name " + s);
			System.out.println("Age " + i);
		};

		biConsumer.accept("udemy", 10);

		List<String> list = new ArrayList();
		list.add("abcd");
		list.add("efgh");
		list.add("ijkl");

		Consumer<String> insertToDB = (s) -> {
			System.out.println("insert into DB - " + s);
		};

		Consumer<String> insertToLogFile = (s) -> {
			System.out.println("insert into logfile - " + s);
		};

		Consumer<String> dbLogBothConsumer = insertToDB.andThen(insertToLogFile);

		Map<String, Consumer<String>> map = new HashMap();
		map.put("db", insertToDB);
		map.put("log", insertToLogFile);
		map.put("dblog", dbLogBothConsumer);

		map.forEach((k, v) -> {
			System.out.println("key is " + k);
		});

	}

}
