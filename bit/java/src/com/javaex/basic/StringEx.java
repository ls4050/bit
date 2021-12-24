package com.javaex.basic;

public class StringEx {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
//		stringEx();
		stringFormatEx();
	}
	
	private static void stringFormatEx() {
		// %d, %s, %f, $n, %% ...
		String fruit = "사과";
		int total=10;
		int eat=3;
		
		//템플릿 문자열
		System.out.printf("%d개의 %s중에서 %d개를 먹었다%n", total, fruit, eat);
		
		//현재 이자율은 1.2% 입니다.
		float rate = 1.2f;
		System.out.printf("현재 이자율은 %.1f%% 입니다.", rate);
	}
	
	private static void stringEx() {
		String str1; // 선언
		str1 = "Java"; // Literal
		String str2 = "Java"; // Literal
		String str3 = new String("Java"); // 참조객체

		System.out.println("str1 == str2 ? " + (str1 == str2));
		System.out.println("str1 == str3 ? " + (str1 == str3));
		
		//참조 객체의 경우, ==, != 은 객체의 메모리 주소의 동일성 확인
		//참조 객체의 값의 비교: equals
		System.out.println("str1과 str3의 값은 같은가? " + str1.equals(str3));
	}

}
