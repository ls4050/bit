package com.javaex.api.generic;

public class BoxApp {

	public static void main(String[] args) {
		IntBox iBox = new IntBox();
		iBox.setContent(10);
		System.out.println("intBox:" + iBox.getContent());
		
		StrBox sBox = new StrBox();
		sBox.setContent("String");
		System.out.println("strBox:" + sBox.getContent());
		
		ObjBox oBox = new ObjBox();
		oBox.setContent(10);
		oBox.setContent("String");
		
		String value = (String) oBox.getContent();
		System.out.println("content:" + value);
//		int iValue = (int)oBox.getContent();
		
		//데이터 꺼낼 때 불편함 => 제네릭으로 해결
		GenericBox<Integer> intGBox = new GenericBox<>();//객체화 시킬 때 타입지정
		// 1. 컴파일러에서 타입 체크 가능
		intGBox.setContent(10);
		// 2. 다운캐스팅의 불편을 해소
		Integer iValue = intGBox.getContent();
		System.out.println("content:" + iValue);
		GenericBox<String> strGBox = new GenericBox<>();
	}

}
