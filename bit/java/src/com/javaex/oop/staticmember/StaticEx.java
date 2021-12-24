package com.javaex.oop.staticmember;

public class StaticEx {
	public static int refCount; // 클래스(staitc) 멤버
	public static String classVar; // 클래스 멤버
	public String instanceVar; // 인스턴스 멤버
	
	// static 블록으로 static 영역의 초기화
	static {
		refCount = 0;
		classVar = "Static Member";
//		instanceVar = "Instance Member"; 인스턴스는 접근이 안된다
		// 중요 : static 영역에서는 static만 접근 가능
		System.out.println("Static Block");
	}
	
	// 생성자 = 인스턴스 영역
	StaticEx() {
		// 참조 카운트 증가
		// 인스턴스 멤버 -> static 멤버 접근은 가능
		refCount++;
		System.out.println("인스턴스 갯수:" + refCount);
		System.out.println("생성자 호출: 인스턴스 생성");
	}
	
	// 소멸자
	@Override
	protected void finalize() throws Throwable {
		refCount--;
		System.out.println("소멸자 호출");
		super.finalize();
	}
}
