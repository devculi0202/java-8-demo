package com.devculi.java8.stream.reduce.customize;

public class BiFunctionCustomImpl implements BiFunctionCustom<Integer, String, Integer> {

	@Override
	public Integer apply(Integer t, String u) {
		System.out.println("identity is+ "+ t);
		System.out.println("element is+ "+ u);
		int result = u.length()+t; 
		System.out.println("Result is" + result);
		return result;
	}

	
}
