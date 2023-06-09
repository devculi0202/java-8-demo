package com.devculi.java8.stream.reduce;

import java.util.List;

import com.devculi.java8.stream.reduce.customize.BiFunctionCustom;
import com.devculi.java8.stream.reduce.customize.BiFunctionCustomImpl;
import com.devculi.java8.stream.reduce.customize.BinaryOperatorCustom;
import com.devculi.java8.stream.reduce.customize.IntegerBinaryOperatorCustomImpl;
import com.devculi.java8.stream.reduce.customize.ReduceCustom;


public class ReduceDemo {
	public static void main(String[] args) {
		List<Integer> integers = List.of(1,2,3);
		
		//customize reduce method
		BinaryOperatorCustom<Integer> accumulator = new IntegerBinaryOperatorCustomImpl();
		ReduceCustom<Integer> reduceCustom = new ReduceCustom<>(integers);
		System.out.println(reduceCustom.reduce(accumulator));
		
		System.out.println(reduceCustom.reduce(3, accumulator));
		
		
		//use stream
		System.out.println(integers.stream().reduce((a,b)->a+b));
		System.out.println(integers.stream().reduce(3, (a,b)->a+b));
		
		
//		4 string: "one", "two","three","four"; ->  sum their lengths;
		List<String> strings = List.of("one","two","three","four");
		ReduceCustom<String> reduceCustomStr = new ReduceCustom<>(strings);
		BiFunctionCustom<Integer, String, Integer> accumulateInt = new BiFunctionCustomImpl();
		BinaryOperatorCustom<Integer> combinerInt = new IntegerBinaryOperatorCustomImpl();
		System.out.println(reduceCustomStr.reduce(0, accumulateInt, combinerInt)); 
		
		System.out.println(strings.stream().reduce(0, (accumulatedInt, str ) -> accumulatedInt + str.length(), 
                (accumulatedInt, accumulatedInt2) -> accumulatedInt + accumulatedInt2)); 
		
	}
}
