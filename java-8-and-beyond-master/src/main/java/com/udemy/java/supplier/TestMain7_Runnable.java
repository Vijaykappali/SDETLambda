package com.udemy.java.supplier;

public class TestMain7_Runnable {

	public static void main(String[] args) {

		// Runnable run1 = () -> System.out.println("ff");

		// run1.run();

		// new Thread(run1).start();

		Runnable run1 = () -> {
			try {
				Thread.sleep(2000);
			} catch (InterruptedException e) {

			}
			System.out.println("run1");
		};

		new Thread(run1).start();

		System.out.println("Main");
	}

}
