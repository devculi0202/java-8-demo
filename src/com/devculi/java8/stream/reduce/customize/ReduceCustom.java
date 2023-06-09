package com.devculi.java8.stream.reduce.customize;

import java.util.List;
import java.util.Optional;

public class ReduceCustom<T> {

	private List<T> stream;
	
	public ReduceCustom(List<T> stream) {
		this.stream = stream;
	}
	/*
	 accumulator is who storing the results of what has been calculated
	 */
	public Optional<T> reduce(BinaryOperatorCustom<T> accumulator) {
		boolean foundAny = false;
	     T result = null;
	     for (T element : stream) {
	         if (!foundAny) {
	             foundAny = true;
	             result = element;
	         }
	         else {
	        	 result = accumulator.apply(result, element);
	         }
	     }
	     return foundAny ? Optional.of(result) : Optional.empty();
	 }
	
	public T reduce(T identity, BinaryOperatorCustom<T> accumulator) {
		T result = identity;
		for(T element : stream) {
			result = accumulator.apply(result, element);
		}
		return result;
	}

     public <U> U reduce(U identity, BiFunctionCustom<U, ? super T, U> accumulator, BinaryOperatorCustom<U> combiner) {
		U result = identity;
		for (T element : stream) {
			U accumulateU = accumulator.apply(identity, element);
			result = combiner.apply(result, accumulateU);
		}
		return result;
	}
	
}
