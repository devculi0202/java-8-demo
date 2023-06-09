package com.devculi.java8.stream.sort;

import java.util.Comparator;

public class AgeComparator implements Comparator<People> {

	@Override
	public int compare(People o1, People o2) {
		if (o1.getAge() < o2.getAge()) {
			return -1;
		}
		return o1.getAge() == o2.getAge() ? 0 : 1;
	}

}
