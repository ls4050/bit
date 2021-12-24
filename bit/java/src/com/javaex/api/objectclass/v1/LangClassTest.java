package com.javaex.api.objectclass.v1;

public class LangClassTest {

	public static void main(String[] args) {
		Point p = new Point(10, 10);
		
		// object 의 메서드를 기본 상속
		System.out.println(p.getClass()); // 이 클래스의 정보 불러옴
		System.out.println(p.hashCode()); // 객체 식별자
		System.out.println(Integer.toBinaryString(p.hashCode()));
		System.out.println(p);
		System.out.println(p.toString());
	}

}
