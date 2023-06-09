package com.devculi.java8.stream.sort;

import java.util.List;

/**
 * @author duyle
 *
 */
public class SortedDemo {
	public static void main(String[] args) {
		List<Integer> integers = List.of(8, 9, 4, 0, 1);
		integers.stream().sorted().forEach(System.out::println);

		List<People> peoples = List.of(new People(1, 25), new People(2, 59), new People(3, 17));
		peoples.stream().sorted(new AgeComparator()).forEach(people -> System.out.println(people.getAge()));

	}

}
