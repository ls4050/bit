package com.javaex.api;

public class Member implements Comparable{
	String name;
	
	public Member(String name) {
		this.name = name;
	}

	@Override
	public String toString() {
		return "Member [name=" + name + "]";
	}

	@Override
	public int compareTo(Object o) {
		// 0 : 두 객체의 순번이 같다.
		// 음수 : 순서가 앞이다.
		// 양수 : 순서가 뒤다.
		if(o instanceof Member) {
			Member other = (Member)o; // 두 객체의 필드에 접근 가능
			return name.compareTo(other.name);
		}
		return 0;
	}
	
	
}
