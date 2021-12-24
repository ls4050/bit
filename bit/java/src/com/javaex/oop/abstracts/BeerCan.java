package com.javaex.oop.abstracts;

public class BeerCan extends EmptyCan{
	
	String s1 = new String("Hello World");
	String ss = new String("Hello World");
	
	public void printContent() {
		System.out.println("흑맥주");
	}
	
	public void printName() {
		System.out.println("맥주캔입니다");
	}
	
	//새로운 멤버 메소드 추가
	public void sayHello() {
		System.out.println("안녕하세요 맥주캔입니다");
	}
	
	public static void main(String[] args) {
		BeerCan b = new BeerCan();
		b.printContent();
		b.printName();
		b.sayHello();
	}

}
