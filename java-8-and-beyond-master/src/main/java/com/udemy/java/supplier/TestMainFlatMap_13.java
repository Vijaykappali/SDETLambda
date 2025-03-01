package com.udemy.java.supplier;

import java.util.ArrayList;
import java.util.List;

public class TestMainFlatMap_13 {

	public static void main(String[] args) {
		// TODO Auto-generated method stub

		List<Integer> a = new ArrayList<>();
		a.add(1);
		a.add(2);
		a.add(3);

		List<Integer> b = new ArrayList<>();
		b.add(4);
		b.add(5);
		b.add(6);

		List<Integer> c = new ArrayList<>();
		c.add(7);
		c.add(8);
		c.add(9);

		List<List<Integer>> list = new ArrayList<>();
		list.add(a);
		list.add(b);
		list.add(c);

		list.stream().forEach(l -> System.out.println(l));

		list.stream().flatMap(l -> l.stream()) // flat map
				.forEach(l -> System.out.println(l));
	}

}
