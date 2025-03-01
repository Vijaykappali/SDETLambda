package com.udemy.java.supplier;

import java.util.function.Predicate;

public class TestMain5_Predicate {

	public static void main(String[] args) {
		Predicate<Integer> isGT2 = (n) -> n > 2;

		Predicate<Integer> isLT10 = (n) -> n < 10;

		System.out.println(isGT2.test(5));

		System.out.println(isLT10.test(50));

		System.out.println(isGT2.negate().test(3));

		System.out.println(isGT2.and(isLT10).test(5));

		System.out.println(isGT2.and(isLT10).test(11));

	}

}
