package com.devculi.java8.stream.reduce.customize;

import java.util.Objects;
import java.util.function.Function;

public interface BiFunctionCustom<T, U, R> {
	R apply(T t, U u);
	 
	// ignore it temporarily.
	default <V> BiFunctionCustom<T, U, V> andThen(Function<? super R, ? extends V> after) {
		Objects.requireNonNull(after);
		return (T t, U u) -> after.apply(apply(t, u));
	};

}
