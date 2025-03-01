package com.udemy.java;

import java.util.function.Supplier;

public class Testmain3_Supplier {

	public static void main(String[] args) {

		Supplier<Double> s = () -> Math.random();

		System.out.println(s.get());

		Supplier<Double> s1 = Math::random;

		System.out.println(s1.get());
	}

}
