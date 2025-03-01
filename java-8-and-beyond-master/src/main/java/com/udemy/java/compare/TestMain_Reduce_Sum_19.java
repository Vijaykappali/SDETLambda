package com.udemy.java.compare;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.Optional;
import java.util.stream.IntStream;

public class TestMain_Reduce_Sum_19 {

	public static void main(String[] args) {
		// TODO Auto-generated method stub

		List<Integer> list = new ArrayList<>();

		Collections.addAll(list, 1, 2, 3, 4, 5, 6);

		Optional<Integer> sum = list.stream().reduce((a, b) -> {
			System.out.println(a + " " + b);
			return a + b;
		});

		Optional<Integer> sum2 = list.stream().reduce((a, b) -> a + b);

		System.out.println(sum.get());

		System.out.println(sum2.get());

		// by using mapToInt

		int sumBymapInt = list.stream().mapToInt(a -> a).sum();

		System.out.println(sumBymapInt);

		IntStream.range(1, 10).forEach(s -> System.out.println("number " + s));
	}

}
