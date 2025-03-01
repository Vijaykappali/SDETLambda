package com.udemy.java.supplier;

import java.util.function.Function;

public class TestMain6_Function {
	public static void main(String[] args) {
		Function<String, Integer> f1 = S -> S.length();

		Function<Integer, Integer> f2 = i -> i * i;

		System.out.println(f1.apply("vijay"));

		System.out.println(f2.apply(4));

		System.out.println(f1.andThen(f2).apply("aa"));

		compose();
	}

	public static void compose() {
		Function<Integer, Integer> plus2 = i -> i + 2;

		Function<Integer, Integer> square = i -> i * i;

		System.out.println(plus2.andThen(square).apply(2));

		System.out.println(plus2.compose(square).apply(2));
	}

}
