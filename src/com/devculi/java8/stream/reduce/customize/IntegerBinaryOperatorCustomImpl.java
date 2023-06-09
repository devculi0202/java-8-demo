package com.devculi.java8.stream.reduce.customize;

public class IntegerBinaryOperatorCustomImpl implements BinaryOperatorCustom<Integer> {

	@Override
	public Integer apply(Integer t, Integer u) {
		System.out.println("t is"+ t);
		System.out.println("u is"+ u);
		return t+u;
	}

	
}
