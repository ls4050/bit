package com.javaex.api.collection.hash;

import java.util.Hashtable;
import java.util.Iterator;
import java.util.Map;

public class HashtableEx {

	public static void main(String[] args) {
		Map<String, Integer> map = new Hashtable<>();
		// 키의 타입 = 스트링  겟 타입 = 인티저
		// 키-값의 쌍으로 저장
		map.put("SOCCER", 11);
		map.put("BASEBALL", 9);
		map.put("VOLLEYBALL", 6);
		
		System.out.println(map);
		// 키는 HashSet: 키는 중복될 수 없고, 순서가 없다
		map.put("VOLLEYBALL", 12); // 새로 생성하는것이 아니라 덮어쓰기임
		System.out.println(map);
		
		// 키 포함여부
		System.out.println("SOCCER 키가 있는가 ? " + map.containsKey("SOCCER"));
		// 값 포함여부
		System.out.println("값에 9가 있는가 ? " + map.containsValue(9));
		
		// Iterator
		Iterator<String> it = map.keySet().iterator();
		while(it.hasNext()) { // 뒤에 있니?
			String key = it.next(); // 뒤의 요소를 받아와라
			System.out.printf("Key %s => value %d%n", key, map.get(key));
		}
		
		// 맵 비우기
		map.clear();
		System.out.println(map);
	}

}
