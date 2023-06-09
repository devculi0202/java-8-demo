package com.devculi.java8.stream.reduce;

import java.util.List;

import com.devculi.java8.stream.reduce.customize.BiFunctionCustom;
import com.devculi.java8.stream.reduce.customize.BiFunctionCustomImpl;
import com.devculi.java8.stream.reduce.customize.BinaryOperatorCustom;
import com.devculi.java8.stream.reduce.customize.IntegerBinaryOperatorCustomImpl;
import com.devculi.java8.stream.reduce.customize.ReduceCustom;

/**
 * @author duyle Use reduce method of stream api
 *
 */
public class ReduceDemo {
	public static void main(String[] args) {
		/* caculate sum of list integers. */
		List<Integer> integers = List.of(1, 2, 3);
		// use stream
		System.out.println(integers.stream().reduce((a, b) -> a + b));
		System.out.println(integers.stream().reduce(3, (a, b) -> a + b));
		// customize reduce method
		BinaryOperatorCustom<Integer> accumulator = new IntegerBinaryOperatorCustomImpl();
		ReduceCustom<Integer> reduceCustomInt = new ReduceCustom<>(integers);
		System.out.println(reduceCustomInt.reduce(accumulator));
		System.out.println(reduceCustomInt.reduce(3, accumulator));
		
		

		/* 4 string: "one", "two","three","four"; ->  sum their lengths */
		List<String> strings = List.of("one", "two", "three", "four");
		ReduceCustom<String> reduceCustomStr = new ReduceCustom<>(strings);
		BiFunctionCustom<Integer, String, Integer> accumulateInt = new BiFunctionCustomImpl();
		BinaryOperatorCustom<Integer> combinerInt = new IntegerBinaryOperatorCustomImpl();
		// use stream
		System.out.println(strings.stream().reduce(0, (accumulatedInt, str) -> accumulatedInt + str.length(),
				(accumulatedInt, accumulatedInt2) -> accumulatedInt + accumulatedInt2));
		// customize reduce method
		System.out.println(reduceCustomStr.reduce(0, accumulateInt, combinerInt));

	}
}
