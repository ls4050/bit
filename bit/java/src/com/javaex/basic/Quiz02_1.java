package com.javaex.basic;

public class Quiz02_1 {
	public static void main(String[] args) {
		int a = 3;
		int b = 6;
		char c = 'A';

		boolean r, r0;
		// Q1
		// a는 짝수입니까? true or false로 출력하세요.
		r = a % 2 == 1 ? true : false;
		System.out.println(r);

		// b는 3의 배수입니까? true or false로 출력하세요.
		r0 = b % 3 == 0 ? true : false;
		System.out.println(r0);

		// 'a는 짝수이다'와 'b는 3의 배수이다'를 논리곱(AND)으로 연산하여 해당 진위값을 r1 변수에 저장해 봅시다.
		// 결과값 r1을 출력해 봅시다.
		boolean r1 = r && r0;
		System.out.println(r1);

		// c의 4글자 뒤의 문자는 무엇입니까? 결과값을 r2 변수에 저장해 봅시다.
		// 결과값 r2를 출력해 봅시다.
		char r2 = (char) (c + 4);
		System.out.println(r2);
		System.out.println(r2);
	}
}
