package com.gms.web.generic;

import java.util.ArrayList;
import java.util.List;

public class Box<T> {
	
		T item;
		ArrayList<T> list=new ArrayList<>();
		public Box() {}
		public Box(List<T> list) {
			this.list=new ArrayList<>();
		}
		public void add(T item) {list.add(item);}
		public T get(int i) {return list.get(i);}
		public ArrayList<T> getList() {return list;}
		int size() {return list.size();}
		public String toString() {return list.toString();}



		
}
