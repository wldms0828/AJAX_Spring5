package com.gms.web.generic;

import java.util.Collections;

public class CarMain {
	@SuppressWarnings("unused")
	public static void main(String[] args) {
		CarBox<BMW> bmwBox = new CarBox<>();
		CarBox<Avante> avanteBox = new CarBox<>();
		CarBox<Car> cbox = new CarBox<>();
		avanteBox.add(new Avante("아반떼a", 1500));
		avanteBox.add(new Avante("아반떼b", 1800));
		avanteBox.add(new Avante("아반떼c", 2000));
		bmwBox.add(new BMW("BMWa", 1900));
		bmwBox.add(new BMW("BMWb", 2500));
		bmwBox.add(new BMW("BMWc", 2500));
		cbox.add(new Avante("아반떼a", 1500));
		cbox.add(new Avante("아반떼b", 1800));
		cbox.add(new Avante("아반떼c", 2000));
		cbox.add(new BMW("BMWa", 1900));
		cbox.add(new BMW("BMWb", 2500));
		cbox.add(new BMW("BMWc", 2500));
		Collections.sort(avanteBox.getList(),new CarOrder());
		Collections.sort(bmwBox.getList(),new CarOrder());
		Collections.sort(cbox.getList(),new CarOrder());
		System.out.println(avanteBox);
		System.out.println(bmwBox);
		System.out.println(bmwBox);
	}
}
