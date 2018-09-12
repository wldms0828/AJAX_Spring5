package com.gms.web.lambda;

import java.util.function.Consumer;
import java.util.function.Function;



/*
 * Consumer<T>  void accept(T t)  메소드가 1개 C,U,D
 * Function<T,R>  apply(T t) Read, T는 파라미터 R은 리턴
 * Predicate<T> boolean test(T t) LOGIN
 * Supplier<T> T get() Count
 * */
public class LambdaMethod {
	public static void main(String[] args) {
		Function<String, Integer> f = Integer::parseInt;
			//파라미터로 들어온 값이 s하나 이니까 두번 쓸 필요가 없다.
			//따라서 = s-> Integer.parseInt(s);를 위처럼 변경해 준다.
			//메소드 앞에 ::를 쳐준다.
			int a = f.apply("1");
			System.out.println(a);
			Consumer<String> c = System.out::println;
			//파라미터하나고 리턴 없으니까 s-> System.out.println(s);를 위처럼 변경해 준다.
			//들어가는 타입이 하나로 정의되어 있을때 사용가능하다.
			c.accept("Hello Lambda");
			
	}
}
