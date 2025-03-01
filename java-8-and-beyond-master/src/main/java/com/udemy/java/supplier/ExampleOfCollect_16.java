package com.udemy.java.supplier;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

public class ExampleOfCollect_16 {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		// collector();

		groupBy();
	}

	public static void collector() {
		List<String> list = new ArrayList<>();
		list.add("cat");
		list.add("elephant");
		list.add("ball");
		list.add("apple");

		List<String> newList = list.stream().filter(s -> s.length() > 3).collect(Collectors.toList());

		System.out.println(list);
		System.out.println(newList);

	}

	public static void groupBy() {
		List<String> list = new ArrayList<>();
		list.add("cat");
		list.add("elephant");
		list.add("ball");
		list.add("apple");

		Map<Integer, List<String>> map1 = list.stream().collect(Collectors.groupingBy(s -> s.length()));

		System.out.println(map1);

		Map<Character, List<String>> map2 = list.stream().collect(Collectors.groupingBy(s -> s.charAt(0)));

		System.out.println(map2);

	}

}
