package com.udemy.calculator;

public class TestMain2_MathOperation {

	@FunctionalInterface
	public interface TriConsumer {
		void accept(String a, String b, int c);
	}

	public interface Person {
	}

	public static void main(String[] args) {

		MathOperation add = (c, d) -> c + d;

		MathOperation subtract = (c, d) -> c - d;

		MathOperation multiply = (c, d) -> c * d;

		System.out.println(calculate(add));

		System.out.println(calculate(subtract));

		System.out.println(calculate(multiply));

		int onScreenNumber = 0;

		onScreenNumber = calculate2(5, add, 2);
		onScreenNumber = calculate2(onScreenNumber, subtract, 3);
		onScreenNumber = calculate2(onScreenNumber, multiply, 7);
		onScreenNumber = calculate2(onScreenNumber, add, 3);

		System.out.println(onScreenNumber);

	}

	private static int calculate(MathOperation op) {
		int a = 100;
		int b = 5;
		return op.operate(a, b);
	}

	private static int calculate2(int onScreenNumber, MathOperation op, int enteredNumber) {

		return op.operate(onScreenNumber, enteredNumber);
	}

}
