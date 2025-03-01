package com.udemy.java;

import com.udemy.java.lambda.GreetingService;
import com.udemy.java.polymorphism.Animal;

public class TestMain_lambdaInro {

	public static void main(String[] args) {

		// Before extending Animal parent

		// Dog dog = new Dog();
		// test(dog);

		// Cat cat = new Cat();
		// test(cat);

		// After extending parent Animal
		// Dog dog = new Dog();
		// Cat cat = new Cat();
		// Horse horse = new Horse();
		// test(horse);

//		Animal a = new Dog();
//		test(a);
//
//		a = new Cat();
//		test(a);
//
//		a = new Horse();
//		test(a);
//		===========================================================================================
//		GreetingService g1 = new GreetingService() {
//
//			@Override
//			public String greet(String firstName) {
//				System.out.println(firstName.toUpperCase());
//				return firstName.toUpperCase();
//			}
//		};
//		g1.greet("hello");
//========================================================================================================
//		GreetingService g1 = (firstName) -> {
//			System.out.println(firstName.toUpperCase());
//			System.out.println(firstName.length());
//		};

//		g1.greet("hello");
//=========================================================================================================
//		GreetingService g2 = firstName -> {
//			return firstName.toLowerCase();
//		};
//
//		System.out.println(g2.greet("AWS"));

//		OR

		GreetingService g2 = firstName -> firstName.toUpperCase();

		// System.out.println(g2.greet("tyh"));

		// test(g2);

		// test(n -> n.substring(2) + n.toLowerCase() + n.length());

		// test(n -> n.substring(2, 4));

		System.out.println(getLambda().greet("vijay"));

	}

	// Before extending Animal parent

	/*
	 * private static void test(Dog d) { d.makeSound(); d.walk(); }
	 *
	 * private static void test(Cat c) { c.makeSound(); c.walk(); }
	 */

	// After extending parent Animal
	private static void test(Animal a) {
		a.makeSound();
		a.walk();
	}

	private static void test(GreetingService g) {
		String returnedString = g.greet("vijay");
		System.out.println(returnedString);
	}

	private static GreetingService getLambda() {
		// GreetingService g = s -> s.toUpperCase();
		return s -> s.toUpperCase();

	}

}
