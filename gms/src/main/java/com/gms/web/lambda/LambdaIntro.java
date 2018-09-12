package com.gms.web.lambda;
/**
 * 람다식(함수)은
 * 식 : expression . EL${total - page} 한 공간에서 결과가 나오는 것을 식이라고 한다.
 * 함수 : function . aa(p){x=2+p; return x;} 상태때문에 식으로 표현해야할 때 함수라 한다.
 * 람다는 연산식이 하나면 {} 이 생략가능하다. 두 개 이상이면 {}을 생략할 수 없기 때문에 식, 함수라고 같이 부른다.
 * */
public class LambdaIntro {
	@SuppressWarnings("unchecked")
	public static void main(String[] args) {
/*		int a =Num.execute((t1, t2) -> t1+t2, 5, 3);*/
		System.out.println(Num.execute((t1, t2) -> t1>t2 ? t1:t2, 5, 3));
	}
	@FunctionalInterface
	interface Calc<T>{T execute(T t1, T t2);}
	static class Num{
		public static <T> T execute(Calc<T> c,T t1,T t2) {
			return c.execute(t1, t2);
		}
	}
}

