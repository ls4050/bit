package com.javaex.api.collection.hash;

import java.util.HashSet;

public class HashSetEx {
	// Hash 알고리즘을 사용하는 컬렉션
	// HashSet 순서가 없다. 중복을 허용하지 않음
	public static void main(String[] args) {
//		hashSetEx();
		hashSetCustom();
	}
	
	private static void hashSetCustom() {
		HashSet<Student> hs = new HashSet<>();
		
		Student s1 = new Student("홍길동", 1);
		Student s2 = new Student("홍길동", 2);
		Student s3 = new Student("홍길동", 1);
		//메모리 주소가 다 다르므로 다 해시코드 다른거 갖고있음
		
		hs.add(s1); hs.add(s2); hs.add(s3);
		
		System.out.println(hs);
	}
	
	private static void hashSetEx() {
		HashSet<String> hs = new HashSet<>();
		
		// 객체 추가
		hs.add("Java");
		hs.add("C");
		hs.add("Python");
		hs.add("Java");
		// 중복 허용 안한다
		System.out.println(hs);
		
		// 원소의 갯수
		System.out.println("hs size=" + hs.size());
		
		// 포함여부
		System.out.println("contains Java ? " + hs.contains("Java"));
		System.out.println("contains Linux ? " + hs.contains("Linux"));
		
		// 객체 삭제
		hs.remove("Python");
		System.out.println(hs);
	}

}
