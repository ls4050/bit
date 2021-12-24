package com.javaex.basic;

import java.util.Arrays;

public class ArrayEx {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
//		arrayEx();
//		twoDimenEx();
//		arrayCopyFor();
		arrayCopySystem();
	}
	
	private static void arrayCopySystem() {
		int source[] = { 1, 2, 3 };
		int target[] = new int[10];
		
		System.arraycopy(source, // 원본 배열
				0, // 시작 인덱스
				target, // 복사 대상 배열
				0, // 대상 배열 인덱스
				source.length // 복사할 길이
				);
		
		System.out.println("원본 : " + Arrays.toString(source));
		System.out.println("복제 : " + Arrays.toString(target));
	}

	private static void arrayCopyFor() {
		int source[] = { 1, 2, 3 };
		int target[] = new int[10];

		// 배열 복사
		for (int i = 0; i < source.length; i++) {
			target[i] = source[i];
		}
		
		System.out.println("원본 : " + Arrays.toString(source));
		System.out.println("복제 : " + Arrays.toString(target));
	}

	private static void twoDimenEx() {
		// 2차원 배열 선언
		int twoDimen[][] = new int[5][10]; // 5행 10열 배열

		// 기본 데이터가 있을 때
		int[][] table = { { 1, 2, 3, 4, 5, 6, 7, 8, 9, 0 }, // 1행
				{ 2, 3, 4, 5, 6, 7, 8, 9, 0, 1 }, // 2행
				{ 3, 4, 5, 6, 7, 8, 9, 0, 1, 2 }, // 3행
				{ 4, 5, 6, 7, 8, 9, 0, 1, 2, 3 }, // 4행
//				{ 5, 6, 7, 8, 9, 0, 1, 2, 3, 4 } 
		};

		// 행배열 확인
		// 0 ~ table.length - 1
		System.out.println("table.length: " + table.length);
		// 열배열 확인:
		System.out.println("table[2].length: " + table[2].length);

		int sum = 0;

		for (int row = 0; row < table.length; row++) { // 행루프
			for (int col = 0; col < table[row].length; col++) {
				// 열루프
				System.out.print(table[row][col] + " ");
				sum += table[row][col];
			}
			System.out.println();
		}

		System.out.println("요소의 합 : " + sum);
	}

	private static void arrayEx() {
		// 배열의 선언
		String[] names; // Type[] 식별자, 주소일 뿐임 배열 사이즈 절대 못들어감
		int scores[]; // Type 식별자[], 주소일 뿐임 배열 사이즈 절대 못들어감

		// 초기화
		names = new String[] { "홍길동", "고길동", "장길산", "임꺽정" }; // 초기화 동시에 사이즈 부여

		// 값 목록이 있다면
		float height[] = { 175.5f, 178.3f, 170.2f, 165 };

		scores = new int[4];
		System.out.println("배열의 길이:" + scores.length);
		// 인덱스의 범위 : 0 ~ .length - 1
		scores[0] = 90;
		scores[1] = 80;
		scores[2] = 85;
		scores[3] = 75;
//		scores[4] = 100;

		for (int i = 0; i < scores.length; i++) {
			System.out.printf("%s, %.2f, score = %d%n", names[i], height[i], scores[i]);
		}

		int[] scores2 = scores; // scores의 주소를 가리킴

		System.out.println("score:" + Arrays.toString(scores)); // Array.toString 으로 일일이 안찍고 한번에 배열 가져올 수 있다
		System.out.println("score2:" + Arrays.toString(scores2));

		scores2[2] = 100;

		System.out.println("score:" + Arrays.toString(scores));
		System.out.println("score2:" + Arrays.toString(scores2));

		System.out.println("scores == scores2 : " + (scores == scores2));
	}
}
