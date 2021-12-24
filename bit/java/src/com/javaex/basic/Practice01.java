package com.javaex.basic;

import java.util.Arrays;
import java.util.Scanner;

public class Practice01 {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
//		problem01();
//		problem02();
//		problem03();
//		problem04();
//		problem05();
//		problem06();
		problem07();
	}

	private static void problem01() {
//		 1에서 100까지의 수에서 5의배수 이면서 7의 배수인 수를 출력하세요
		for (int i = 1; i <= 100; i++) {
			if (i % 5 == 0 && i % 7 == 0)
				System.out.println(i);
		}
	}

	private static void problem02() {
		System.out.println("숫자를 입력하세요.");
		Scanner sc = new Scanner(System.in);
		int num = sc.nextInt();

		for (int i = 1; i <= num; i++) {
			for (int j = 1; j <= i; j++) {
				System.out.print(i);
			}
			System.out.println();
		}
	}

	private static void problem03() {
		for (int i = 1; i <= 9; i++) {
			for (int j = 2; j <= 9; j++) {
				System.out.printf("%d*%d=%d\t", j, i, i * j);
			}
			System.out.println();
		}
	}

	private static void problem04() {
		for (int i = 0; i <= 9; i++) {
			for (int j = 1; j <= 10; j++) {
				System.out.printf("%d\t", j + i);
			}
			System.out.println();
		}
	}

	private static void problem05() {
		System.out.println("숫자를 입력하세요.");
		Scanner sc = new Scanner(System.in);
		int arr[] = new int[5]; // 5개 만든다는 뜻 인덱스는 0~4 임
		for (int i = 0; i < 5; i++) {
			System.out.print("숫자 : ");
			arr[i] = sc.nextInt();
		}
		Arrays.sort(arr);
		System.out.println("최대값은 " + arr[4]);
		System.out.println(Arrays.toString(arr));
	}

	private static void problem06() {
		Scanner sc = new Scanner(System.in);
		System.out.println("숫자를 입력하세요");
		int num = sc.nextInt();
		int temp = 0;
		if (num % 2 == 1) {
			for (int i = 1; i <= num; i++) {
				if (i % 2 == 1)
					temp += i;
			}
		} else {
			for (int i = 1; i <= num; i++) {
				if (i % 2 == 0)
					temp += i;
			}
		}

		System.out.println("결과값 : " + temp);
	}

	private static void problem07() {
		System.out.println("======================");
		System.out.println("   [숫자맞추기게임 시작]");
		System.out.println("======================");
		int answer = (int) (Math.random() * 100 + 1);
		Scanner sc = new Scanner(System.in);
		System.out.println(answer);
		while (true) {
			System.out.print(">>");
			int num = sc.nextInt();
			if(num<answer) {
				System.out.println("더 높게");			
			} else if (num>answer) {
				System.out.println("더 낮게");								
			} else if (num == answer) {
				System.out.println("맞았습니다.");
				System.out.println("게임을 종료하시겠습니까?(y/n) >>");
				String exit = sc.nextLine();
				System.out.println(exit);
				if(exit.equals("y")) {
					System.out.println("======================");
					System.out.println("   [숫자맞추기게임 종료]");
					System.out.println("======================");
					break;
				}
			}
		}

	}
}
