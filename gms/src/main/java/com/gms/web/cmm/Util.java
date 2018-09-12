package com.gms.web.cmm;

import java.util.function.Consumer;
import java.util.function.Predicate;

import com.google.common.base.Function;

public class Util {
	public static Consumer<Integer> logi = System.out::println;
	public static Consumer<String> log = System.out::println;
	public static Function<String, Integer> convInt = Integer::parseInt;
	public static Predicate<String> p = s->s.equals("");
	public static Predicate<String> notP = p.negate();
	
}
