package com.javaex.api;

import java.util.Arrays;
import java.util.Collections;
import java.util.Comparator;

public class ArrayEx {

	public static void main(String[] args) {
//		arrayCopyEx();
//		basicSortEx();
//		basicDescEx();
//		customClassSort();
		basicSearch();
	}

	private static void basicSearch() {
		int[] scores = { 80, 50, 70, 90, 75, 88, 77 };
		// 이진 검색 방식은 미리 정렬이 되어 있어야
		Arrays.sort(scores);
		System.out.println("원본:" + Arrays.toString(scores));
		int index = Arrays.binarySearch(scores, 75); // scores에서 75가 몇번 인덱스를 갖고있느냐
		System.out.println("75의 인덱스:" + index);
	}

	private static void customClassSort() {
		Member[] members = { 
				new Member("홍길동"), 
				new Member("고길동"), 
				new Member("장길산"), 
				new Member("임꺽정") 
				};

		System.out.println("원본:" + Arrays.toString(members));
		Arrays.sort(members);
		System.out.println("정렬:" + Arrays.toString(members));
//		Arrays.sort(members, Collections.reverseOrder());
//		Arrays.sort(members, new Comparator());
		System.out.println("역순정렬:" + Arrays.toString(members));
//		Arrays.sort(members, new Comparator<Member>);
		
		
		
	}

	private static void basicDescEx() {
		Integer[] scores = { 80, 50, 70, 90, 75, 88, 77 };
		System.out.println("원본:" + Arrays.toString(scores));
		Arrays.sort(scores, Collections.reverseOrder());
		System.out.println("역순정렬:" + Arrays.toString(scores));
	}

	private static void basicSortEx() {
		int[] scores = { 80, 50, 70, 90, 75, 88, 77 };
		System.out.println("원본:" + Arrays.toString(scores));
		Arrays.sort(scores); // 정렬
		System.out.println("정렬:" + Arrays.toString(scores));
	}

	private static void arrayCopyEx() {
		int arr[] = new int[] { 1, 2, 3, 4, 5 };

		// System 이용 복사
		int[] target = new int[arr.length];
		System.arraycopy(arr, // 원본 배열
				0, // 시작인덱스
				target, // 대상 배열
				0, // 시작인덱스
				arr.length); // 복사할 길이

//		arr[0] = 100;
//		if(arr == target) System.out.println("arr target 같음");

		System.out.println("원본 배열:" + Arrays.toString(arr));
		System.out.println("복제 배열:" + Arrays.toString(target));

		// Arrays의 복제 메서드
		target = Arrays.copyOf(arr, // 원본배열
				arr.length); // 복사할 길이
		System.out.println("copyOf:" + Arrays.toString(target));

		// 배열 일부 복제
		target = Arrays.copyOfRange(arr, // 원본 배열
				1, // 복제 시작 인덱스
				3); // 복사 끝 인덱스
		System.out.println("copyOf:" + Arrays.toString(target));
	}
}
