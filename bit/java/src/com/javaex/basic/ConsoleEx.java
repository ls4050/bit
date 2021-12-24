package com.javaex.basic;

import java.util.Scanner;

public class ConsoleEx {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
//		consoleOutputEx();
		consoleInputEx();
	}

	// 콘솔 입력
	private static void consoleInputEx() {
		Scanner sc = new Scanner(System.in);
		System.out.print("이름은?");
		String name = sc.next();
		System.out.print("나이는?");
		int age = sc.nextInt();
		System.out.print("당신의 이름은 " + name + ", 나이는 " + age + "입니다.");
		sc.close();
	}

	// 콘솔 출력
	private static void consoleOutputEx() {
		// System.out.print: 개행안함
		// System.out.println: 개행함
		// System.out.printf: 형식지정 문자열 출력 -> String.format
		System.out.print("Hello ");// 개행 안함
		System.out.println("Java"); // 개행 함

		// 이스케이프 문자
		// \n(개행), \t(탭문자), \"(따옴표), \\(역슬래시)
		System.out.println("Hello\n Java"); // 개행
		System.out.println("Hello\t Java"); // 탭문자
		System.out.println("Hello \"Java\""); // 따옴표

		String dir = "C:\\Users\\Bit\\Desktop"; // 역슬래시
		System.out.println(dir);
	}

}
