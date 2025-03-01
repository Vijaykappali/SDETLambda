package com.udemy.java.supplier;

import java.util.ArrayList;
import java.util.List;

public class TestMain8_Stream_Sort_Peek_Skip_Limit {

	public static void main(String[] args) {

		// sample();

		sortedSample();

		// peekAndSkipSample();

		// sampleTask();
	}

	static void sample() {
		List<Integer> list = new ArrayList<Integer>();

		list.add(1);
		list.add(2);
		list.add(3);
		list.add(4);
		list.add(5);
		list.add(6);
		list.add(7);
		list.add(8);
		list.add(9);
		list.add(10);
		list.add(11);
		list.add(12);

		// list.stream().filter(n -> n % 2 == 0).limit(4).map(n -> n * n).forEach(n ->
		// System.out.println(n));

		list.stream().filter(n -> {
			System.out.println("recieved to check  even - " + n);
			return n % 2 == 0;
		}).limit(4).map(n -> {
			System.out.println("recieved to   square - " + n);
			return n * n;
		}).forEach(n -> System.out.println(n));
	}

	static void sortedSample() {
		List<Integer> list = new ArrayList<Integer>();

		list.add(10);
		list.add(5);
		list.add(8);
		list.add(12);
		list.add(1);
		list.add(6);
		list.add(7);
		list.add(3);
		list.add(9);
		list.add(1);
		list.add(2);
		list.add(4);

		// list.stream().filter(n -> n % 2 == 0).limit(4).map(n -> n * n).forEach(n ->
		// System.out.println(n));

		list.stream().filter(n -> {
			System.out.println("recieved to check  even - " + n);
			return n % 2 == 0;
		}).sorted().limit(4).map(n -> {
			System.out.println("recieved to   square - " + n);
			return n * n;
		}).forEach(n -> System.out.println(n));
	}

	static void peekAndSkipSample() {
		List<Integer> list = new ArrayList<Integer>();

		list.add(1);
		list.add(2);
		list.add(3);
		list.add(4);
		list.add(5);
		list.add(6);
		list.add(7);
		list.add(8);
		list.add(9);
		list.add(10);
		list.add(11);
		list.add(12);

		// PEEK
//		list.stream().peek(n -> System.out.println("recieved to filter - " + n)).filter(n -> n % 2 == 0).limit(4)
//				.peek(n -> System.out.println("recieved to map - " + n)).map(n -> n * n)
//				.forEach(n -> System.out.println(n));

		// SKIP
//		list.stream().skip(4).peek(n -> System.out.println("recieved to filter - " + n)).filter(n -> n % 2 == 0)
//				.limit(4).peek(n -> System.out.println("recieved to map - " + n)).map(n -> n * n)
//				.forEach(n -> System.out.println(n));

		// SKIP
		list.stream().peek(n -> System.out.println("recieved to filter - " + n)).filter(n -> n % 2 == 0).limit(4)
				.peek(n -> System.out.println("recieved to map - " + n)).map(n -> n * n).skip(2)
				.forEach(n -> System.out.println(n));

	}

	static void sampleTask() {
		List<Integer> list = new ArrayList<Integer>();

		list.add(1);
		list.add(2);
		list.add(3);
		list.add(4);
		list.add(5);
		list.add(6);
		list.add(7);
		list.add(8);
		list.add(9);
		list.add(10);
		list.add(11);
		list.add(12);

		// even number
		// greater than 5
		// square and add 2
		// print

		// list.stream().filter(n -> n % 2 == 0).limit(4).map(n -> n * n).forEach(n ->
		// System.out.println(n));

		list.stream().peek(n -> System.out.println("recieved to filter - " + n)).filter(n -> n % 2 == 0)
				.filter(n -> n > 5).peek(n -> System.out.println("recieved to map - " + n)).map(n -> n * n)
				.map(n -> n + 2).forEach(n -> System.out.println(n));
	}

}
