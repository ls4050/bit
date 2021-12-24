package com.javaex.basic;

import java.util.Scanner;

public class ConditionalEx {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
//		ifElseEx();
//		ifElseEx2();
		switchEx2("MON");
	}
	
	private static void switchEx2(String day) {
		String message;
		
		switch (day) {
		case "MON":
		case "TUE":
		case "WED":
		case "THU":
			message = "열공";
			break;
		case "FRI":
			message = "열공 후 불금";
			break;
		case "SAT":
		case "SUN":
			message = "주말";
			break;
		default:
			message = "?";
			break;
		}
		System.out.println(day + "에는 " + message);
	}
	
	
	private static void switchEx3() {
		Scanner sc = new Scanner(System.in);
		System.out.println("월을 입력하세요.");
		int month = sc.nextInt();
		
		
		switch (month) {
		case 1:
		case 3:
		case 5:
		case 7:
		case 8:
			System.out.println("31일 입니다.");
			break;
		case 4:
		case 6:
		case 9:
		case 12:
			System.out.println("30일 입니다.");
			break;
		case 2:
			System.out.println("28일 입니다.");			
		default:
			System.out.println("error");			
			
			break;
		}
		
	}
	
	// switch 연습
	private static void switchEx() {
		Scanner sc = new Scanner(System.in);
		System.out.println("과목을 선택하세요.");
		System.out.println("1.Java  2.C  3.C++  4.Python");
		System.out.print("과목번호 : ");
		int code = sc.nextInt();

		switch (code) {
		case 1:
			System.out.println("R101호 입니다.");
			break;
		case 2:
			System.out.println("R202호 입니다.");
			break;
		case 3:
			System.out.println("R303호 입니다.");
			break;
		case 4:
			System.out.println("R404호 입니다.");
			break;
		default:
			System.out.println("상담원에게 문의하세요.");
			break;
		}
		sc.close();
	}

	// if문 연습2
	private static void ifElseEx2() {
		Scanner sc = new Scanner(System.in);
		System.out.println("과목을 선택하세요.");
		System.out.println("1.Java  2.C  3.C++  4.Python");
		System.out.print("과목번호 : ");
		int code = sc.nextInt();

		if (code == 1) {
			System.out.println("R101호 입니다.");
		} else if (code == 2) {
			System.out.println("R202호 입니다.");
		} else if (code == 3) {
			System.out.println("R303호 입니다.");
		} else if (code == 4) {
			System.out.println("R404호 입니다.");
		} else {
			System.out.println("상담원에게 문의하세요.");
		}

		sc.close();
	}

	// if문 연습
	private static void ifElseEx() {
		Scanner scanner = new Scanner(System.in);

		// if ~ else if ~ else
		System.out.print("정수입력:");
		int num = scanner.nextInt();

//		if (num > 0) {
//			System.out.println(num + "는 양수입니다.");
//		} else if (num < 0) {
//			System.out.println(num + "는 음수입니다.");
//		} else {
//			System.out.println(num + "는 0입니다.");			
//		}

		// 중첩 if
		if (num == 0) {
			System.out.println(num + "는 0입니다.");
		} else { // 양수 or 음수
			if (num > 0) {
				System.out.println(num + "는 양수입니다.");
			} else {
				System.out.println(num + "는 음수입니다.");
			}
		}

		scanner.close();
	}
}
