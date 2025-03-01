package com.udemy.java.supplier;

import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;
import java.util.Optional;

public class TestMainTerminalOperations_14 {

	public static void main(String[] args) {
		// count();
		// findfirst();

		// minAndMax();

		anymatch();
	}

	public static void count() {
		List<String> a = new ArrayList<>();
		a.add("cat");
		a.add("elephant");
		a.add("ball");

		long stringsmorethan3legth = a.stream().filter(s -> s.length() > 3).count();

		System.out.println(stringsmorethan3legth);

	}

	public static void findfirst() {
		List<String> a = new ArrayList<>();
		a.add("cat");
		a.add("elephant");
		a.add("ball");
		a.add("apple");

		Optional<String> FirstOfStringsMoreThan3length = a.stream().filter(s -> s.length() > 3).findFirst();

		System.out.println(FirstOfStringsMoreThan3length);

		if (FirstOfStringsMoreThan3length.isPresent()) {
			String stng = FirstOfStringsMoreThan3length.get();
			System.out.println(stng);
		}

	}

	public static void minAndMax() {
		List<String> a = new ArrayList<>();
		a.add("cat");
		a.add("elephant");
		a.add("ball");
		a.add("apple");

		String min = a.stream().min(Comparator.naturalOrder()).get(); // first element of ascending order

		System.out.println(min);

		String min2 = a.stream().min(Comparator.reverseOrder()).get(); // first element of descedning order

		System.out.println(min2);

		String max = a.stream().max(Comparator.naturalOrder()).get(); // last element of ascending

		System.out.println(max);

		String max2 = a.stream().max(Comparator.reverseOrder()).get(); // last element of descending

		System.out.println(max2);

		// min with filter
		String minFilter = a.stream().filter(S -> S.length() > 3).min(Comparator.naturalOrder()).get(); // first element
																										// of ascending
																										// order with
																										// lentgh more
																										// thna 3

		System.out.println(minFilter);

//		if (FirstOfStringsMoreThan3length.isPresent()) {
//			String stng = FirstOfStringsMoreThan3length.get();
//			System.out.println(stng);
//		}

	}

	public static void anymatch() {
		List<String> a = new ArrayList<>();
		a.add("cat");
		a.add("elephant");
		a.add("ball");
		a.add("apple");

		boolean anymatvh = a.stream().anyMatch(n -> n.contains("f"));

		boolean nonematch = a.stream().noneMatch(n -> n.contains("f"));

		System.out.println(anymatvh);

		System.out.println(nonematch);

	}

}
