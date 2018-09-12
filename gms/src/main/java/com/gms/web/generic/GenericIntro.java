package com.gms.web.generic;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * Generic 은 타입을 창조하는 것 
 * class Member{} -> static 상태로 Member 타입을 생성
 * List<Member>
 * <-> Dynamic한 타입을 생성
 * 예를 들면 e-book을 보느냐 만화책을 보느냐와 같다. 그러나 컨텐츠는 똑같다.
 * 왜 사용하는가?
 * 캐스팅을 안하려고 
 * */

public class GenericIntro {
	@SuppressWarnings({ "static-access" })
	public static void main(String[] args) {
		System.out.println("---------ItemSample[1]----------");
		Item<String> itName = new Item<>();
		itName.setOne("갤노트");
		Item<Integer> itVers = new Item<>();
		itVers.setOne(9);
		System.out.println("삼성 새로운 핸드폰 이름은 : \n"+itName.getOne()+itVers.getOne());
		System.out.println("---------[2]-----------");
		Item<List<String>> it = new Item<>();
		it.setSome(Arrays.asList(new String[] {"HELLO ", "GENERIC ", "WORLD "}));
		//원래였으면 for문을 돌려서 출력할 수 있는데 자바8할 때 for loop 쓰면 옛날 사람되는거다.for loop안쓰고 배열을 출력할 수 있다.
		System.out.println(it.getSome());
		System.out.println("----------[3]----------");
		FruitBox<Fruit> fbox=new FruitBox<>();
		FruitBox<Apple> applebox=new FruitBox<>();
		fbox.add(new Apple());
		fbox.add(new Grape());
		fbox.add(new Apple());
		fbox.add(new Apple());
		
		System.out.println(new Mixer().makeJuice(fbox));
		System.out.println(new Mixer().makeJuice(applebox));
		
	}

}
