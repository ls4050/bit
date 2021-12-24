package com.javaex.grade;

import java.util.Iterator;
import java.util.LinkedList;
import java.util.Scanner;

public class LinkList {

	public void search(LinkedList<Student> list) {
		Scanner sc = new Scanner(System.in);
		System.out.println("1.이름 검색\t2.성적 검색");
		int select = sc.nextInt();
		if (select == 1) {
			System.out.print("이름 입력 : ");
			String str = sc.next();
			Iterator<Student> iterator = list.iterator();
			while (iterator.hasNext()) {
				Student s = iterator.next();
				if (s.getName().equals(str)) {
					System.out.println(s.toString());
				}
			}
		} else if (select == 2) {
			System.out.print("검색할 기준 성적 입력 : ");
			int avg = sc.nextInt();
			Iterator<Student> iterator = list.iterator();
			while (iterator.hasNext()) {
				Student s = iterator.next();
				if (s.getAvg() >= avg) {
					System.out.println(s.toString());
				}
			}
		} else {
			System.out.println("검색 오류");
		}
	}

	public void input(LinkedList<Student> list) {
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

		list.add(stu);
	}

	public void delete(LinkedList<Student> list) {
		Scanner sc = new Scanner(System.in);
		System.out.print("이름을 입력하세요.");
		System.out.println();
		String str = sc.next();
		Iterator<Student> iterator = list.iterator();
		while (iterator.hasNext()) {
			Student s = iterator.next();
			if (s.getName().equals(str)) {
				list.remove(s);
			}
		}
	}

	public void run() {
		Scanner sc = new Scanner(System.in);
		LinkedList<Student> list = new LinkedList<Student>();

		do {
			System.out.print("1.삽입\t2.검색\t3.삭제\t4.출력\n");
			int select = sc.nextInt();
			if (select == 1) {
				input(list);
			} else if (select == 2) {
				search(list);
			} else if (select == 3) {
				delete(list);
			} else if (select == 4) {
				for (Student stu : list) {
					System.out.println(stu.toString());
				}
			} else {
				System.out.println("종료");
				return;
			}
		} while (true);
	}

	public static void main(String[] args) {
		LinkList test = new LinkList();
		test.run();
	}

}