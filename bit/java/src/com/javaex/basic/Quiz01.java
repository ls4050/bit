package com.javaex.basic;

public class Quiz01 {
	public static void main(String[] args) {
		// Q1
		String phoneNumber = "01055466421";

		// Q2
		float interestRate = 0.031f;

		// Q3
		System.out.println("1" + "3"); // 13
		System.out.println(true + "Java"); // trueJava
		System.out.println('A' + 'B'); // 65 + 66 = 131
		System.out.println('1' + 2); // 49 + 2 = 51
		System.out.println('J' + "ava"); // Java
//		System.out.println(false + null);	// null과 boolean은 다른타입 변수

		// Q4
		byte b = 10;
		char ch = 'A';
		int i = 100;
		long l = 1000L;

		byte b2 = (byte) i;
		char ch2 = (char) b;
		short s = (short) ch;
		float f = l;
		int i2 = ch;
	}

}
