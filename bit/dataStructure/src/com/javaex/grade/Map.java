package com.javaex.grade;

import java.util.HashMap;
import java.util.HashSet;
import java.util.Iterator;
import java.util.Scanner;
import java.util.Set;

public class Map {

	public void search(HashMap<String, Student> map) {
		Scanner sc = new Scanner(System.in);
		System.out.println("1.이름 검색\t2.성적 검색");
		int select = sc.nextInt();
		if (select == 1) {
			System.out.print("이름 입력 : ");
			String str = sc.next();
			if (!map.containsKey(str)) {
				System.out.println("찾는 사람이 없어요 !");
			}
			Iterator<String> iterator = map.keySet().iterator();
			while (iterator.hasNext()) {
				String key = iterator.next();
				if (map.get(key).getName().equals(str)) {
					System.out.println(map.get(str));
				}
			}
		} else if (select == 2) {
			System.out.print("검색할 기준 성적 입력 : ");
			int avg = sc.nextInt();
			Iterator<String> iterator = map.keySet().iterator();
			while (iterator.hasNext()) {
				String s = iterator.next();
				if (map.get(s).getAvg() >= avg) {
					System.out.println(map.get(s));
				}
			}
		} else {
			System.out.println("검색 오류");
		}
	}

	public void input(HashMap<String, Student> map) {
		Scanner sc = new Scanner(System.in);
		Student stu = new Student();
		System.out.print("이름 : ");
		stu.setName(sc.next());
		System.out.print("국어 : ");
		stu.setKor(sc.nextInt());
		System.out.print("영어 : ");
		stu.setEng(sc.nextInt());
		System.out.print("수학 : ");
		stu.setMat(sc.nextInt());

		map.put(stu.getName(), stu);
	}

	public void delete(HashMap<String, Student> map) {
		Scanner sc = new Scanner(System.in);
		System.out.print("이름을 입력하세요.");
		System.out.println();
		String str = sc.next();
		if (map.get(str).getName().equals(str)) {
			System.out.println("삭제 완료");
			map.remove(str);
		}else if (map.isEmpty()&&!map.get(str).getName().equals(str)) {
			System.out.println("맵이 비어있습니다.");
		} 
	}

	public void run() {
		Scanner sc = new Scanner(System.in);
		HashMap<String, Student> map = new HashMap<String, Student>();

		do {
			System.out.print("1.삽입\t2.검색\t3.삭제\t4.출력\n");
			int select = sc.nextInt();
			if (select == 1) {
				input(map);
			} else if (select == 2) {
				search(map);
			} else if (select == 3) {
				delete(map);
			} else if (select == 4) {
				for (String key : map.keySet()) {
					System.out.println(map.get(key));
				}
			} else {
				System.out.println("종료");
				return;
			}
		} while (true);
	}

	public static void main(String[] args) {
		Map test = new Map();
		test.run();
	}

}