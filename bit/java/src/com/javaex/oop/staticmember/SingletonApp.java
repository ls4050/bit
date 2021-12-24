package com.javaex.oop.staticmember;

public class SingletonApp {

	public static void main(String[] args) {
//		Singleton s1 = new Singlton(); // 생성자가 private 이기 때문에 접근 불가
		Singleton s = Singleton.getInstance();
		Singleton s2 = Singleton.getInstance();
		
		// 객체 주소가 같으면 같은 객체다
		System.out.println("s1, s2 같은 객체? "+(s == s2));
	}

}
