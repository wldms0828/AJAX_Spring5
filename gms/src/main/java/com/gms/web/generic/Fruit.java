package com.gms.web.generic;

public class Fruit {public String toString() {return "Friut";}}
class Apple extends Fruit {public String toString() {return "Apple";}}
class Grape extends Fruit {public String toString() {return "Grape";}}
class Juice{
	String name;
	Juice(String name){this.name = name + "Juice";}
	public String toString() {return name;}
}
class Mixer{
	static Juice makeJuice(FruitBox<? extends Fruit> box) {
		//FruitBox에는 Fruit만 담을 수 있다.
		//?는 object이다.
		String t="";
		for(Fruit f : box.getList())
		t += f + " ";
		return new Juice(t);
	}
}
class FruitBox<T extends Fruit> extends Box<T>{}