package com.udemy.java;

import java.util.ArrayList;
import java.util.List;

import com.udemy.java.lambda.StringOperations;

public class Testmain2_Lambda2 {

	private static List<String> list = new ArrayList<>();

	public static void main(String[] args) {

//		StringOperations s1 = s -> System.out.println("acccepde");
//
//		s1.accept("Vijay");

//		StringOperations s1 = System.out::println;
//
//		s1.accept("Vijay");

//		=========================================================================================

//		StringOperations s1 = s -> Objects.isNull(s);
//
//		System.out.println(s1.checkBoolean("ddd"));

//		StringOperations s1 = Objects::isNull;
//
//		System.out.println(s1.checkBoolean("ddd"));

//		==============================================================================================

//		StringOperations s1 = (s) -> s.toUpperCase();
//
//		System.out.println(s1.accept("vijay"));

//		StringOperations s1 = String::toUpperCase;
//
//		System.out.println(s1.accept("vijay"));

//		==================================================================================================

//		StringOperations s1 = (c, d) -> c.concat(d);
//
//		System.out.println(s1.accept("AB", "CD"));
//
//		StringOperations s2 = String::concat;
//
//		System.out.println(s2.accept("EG", "SS"));

//     =================================================================================================

		// referring to void accept(String s);
		StringOperations s1 = (d) -> list.add(d);

		s1.accept("vijay");
		System.out.println(list);

		StringOperations s2 = list::add;

		s2.accept("sswsws");
		System.out.println(list);

	}

}
