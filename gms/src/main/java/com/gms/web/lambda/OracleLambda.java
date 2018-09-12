package com.gms.web.lambda;

import java.util.function.Predicate;

/**
 * Consumer<T>  void, accept(T t)  메소드가 1개 C,U,D
 * Function<T,R>  apply(T t) Read
 * Predicate<T> boolean, test(T t) LOGIN
 * Supplier<T> T get() Count
 * UnaryOperator<T>  static <T> identity()
 * UnaryOperator는 단항연산자
 * 이미 만들어져 있다고 생각하면 된다.
 * */
public class OracleLambda {
	public static void main(String[] args) {
		Predicate<String> p = s-> s.length() == 0;
		String x = "";
		String y = "hello";
		String r = (p.test(y)) ? "NULL" : "NOT NULL";
		System.out.println(r);
	}
}
