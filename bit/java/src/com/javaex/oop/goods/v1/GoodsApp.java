package com.javaex.oop.goods.v1;

public class GoodsApp {

	public static void main(String[] args) {
		Goods notebook = new Goods(); // HEAP에 생성
		notebook.name = "Macbook Air";
		notebook.price = 1600000;
		
		Goods smartphone = new Goods();
		smartphone.name = "iPhone 13";
		smartphone.price = 1000000;
		
		System.out.printf("%s, %d원\n", notebook.name, notebook.price);
		System.out.printf("%s, %d원\n", smartphone.name, smartphone.price);
		
	}

}
