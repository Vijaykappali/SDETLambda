package com.udemy.java.compare;

import java.util.Comparator;
import java.util.Optional;
import java.util.stream.Stream;

public class ExampleOfStudent_18 {

	public static void main(String[] args) {
		// TODO Auto-generated method stub

		Student a = new Student("adam", 80, 150);
		Student b = new Student("bob", 70, 450);
		Student c = new Student("Carl", 40, 300);

		Optional<Student> op = Stream.of(a, b, c).min(Comparator.comparing(s -> s.getScore()));

		System.out.println(op.get());

	}

}
