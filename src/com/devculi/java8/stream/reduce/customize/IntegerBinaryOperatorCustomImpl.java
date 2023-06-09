package com.devculi.java8.stream.reduce.customize;

public class IntegerBinaryOperatorCustomImpl implements BinaryOperatorCustom<Integer> {

	@Override
	public Integer apply(Integer t, Integer u) {
		return t+u;
	}

	
}
