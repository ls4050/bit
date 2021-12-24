package com.javaex.api.collection.list;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

public class ListEx {

	// 순서 o 중복 o 가변크기
	public static void main(String[] args) {
		// List는 interface
//		List<String> lst = new LinkedList<>();
		List<String> lst = new ArrayList<>();
		
		// 객체 추가
		lst.add("Java"); // 맨뒤에 새 노드 추가
		lst.add("C");
		lst.add("C++");
		lst.add("Python");
		
		// 객체 삽입
		lst.add(2, "C#"); // 2번인덱스에, 중간에 객체 삽입
		
		System.out.println(lst);
		
		// List는 중복삽입 허용
		lst.add("Java");
		System.out.println(lst);
		
		
		// List 항목 수
		System.out.println("Size:" + lst.size());
		
		// 삭제
		lst.remove(2); // 인덱스로 삭제가능
		lst.remove("Python"); // 객체로 삭제가능
		System.out.println(lst);
		
		// List, Set의 경우 Iterator 사용
		Iterator<String> it = lst.iterator();
		while(it.hasNext()) { // 너 뒤에 데이터 있냐? Vector의 Enumeration 같은 것
			String item = it.next(); // 다음 요소를 가져온다
			System.out.println(item);
		}
		
		// 비우기
		lst.clear();
		System.out.println(lst);
	}

}
