package com.devculi.java8.stream.reduce.customize;

public class BiFunctionCustomImpl implements BiFunctionCustom<Integer, String, Integer> {

	@Override
	public Integer apply(Integer t, String u) {
		int result = u.length()+t; 
		return result;
	}

	
}
