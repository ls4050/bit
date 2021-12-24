package com.javaex.basic;

import java.util.Scanner;

public class LoopEx {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
//		whileEx();
//		gugudan();
//		doWhileEx();
//		forGuGu();
//		continueEx();
//		breakEx();
		diceEx();
	}
	// static 영역을 instance가 접근하기위해 private뒤에 static을 붙혀준것이다.
	private static void diceEx() {
		// 주사위 10번 굴리기
		for (int i=0; i<10; i++) {
			int dice = (int)(Math.random() * 6)+1; //정수난수 생성
			System.out.print(dice + " ");
		}
		System.out.println();
	}

	private static void breakEx() {
//		6의 배수이자 14의 배수인 가장 적은 정수 찾기
		int num = 0;
		while (true) {
			num++;
			if (num % 6 == 0 && num % 14 == 0) {
				System.out.println(num);
				break;
			}
		}
	}

	private static void continueEx() {
		for (int i = 1; i <= 20; i++) {
			if (i % 2 == 0 || i % 3 == 0)
				continue;
			System.out.print(i + " ");
		}
		System.out.println();
	}

	private static void forGuGu() {
		Scanner sc = new Scanner(System.in);
		int dan;
		System.out.println("단을 입력해주세요.");
		System.out.print("단 : ");
		dan = sc.nextInt();

		for (int i = 1; i < 10; i++) {
			int r = dan * i;
			String numStr = String.valueOf(r);
//			System.out.println(dan + " * " + i + " = " + dan * i);
			System.out.printf("%d * %d = %5s", dan, i, r);
			System.out.println();
		}

		sc.close();
	}

	private static void doWhileEx() {
		// 최소 1번 반복 수행할 경우: do while
		int total = 0;
		int num = 0;

		Scanner sc = new Scanner(System.in);

		do {
			System.out.print("숫자를 입력[0이면 종료]:");
			num = sc.nextInt();
			total += num;
		} while (num != 0);

		System.out.println("총합 : " + total);
		sc.close();
	}

	private static void gugudan() {
		Scanner sc = new Scanner(System.in);
		int dan;
		int i = 1;

		System.out.println("단을 입력해주세요.");
		System.out.print("단 : ");
		dan = sc.nextInt();
		while (i < 10) {
			System.out.println(dan + " * " + i + " = " + dan * i);
			i++;
		}
		sc.close();
	}

	private static void whileEx() {
		// 1 ~ 10 반복
		int num = 1;
		while (num <= 10) {
			System.out.println("I like Java" + num);
			// 반복 조건 변수를 적절히 조절
			num++;
		}
	}
}
