package com.javaex.api.objectclass.v2;

public class LangClassTest {

	public static void main(String[] args) {
		Point p = new Point(10, 10);
		
		Point p2 = new Point(10, 10);
		
		System.out.println("p==p2 ? " + ( p == p2));
		// 사용자 정의 객체 비교방법 몰라서 false
		System.out.println("p.equals(p2) ? " + (p.equals(p2))); 
		// p.equals(p2) 에서 p2를 포인트로 DownCasting해줘야함
	}

}
