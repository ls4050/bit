package com.javaex.api.collection.hash;

public class Student {
	int id;
	String name;
	
	public Student(String name,int id) {
		this.id = id;
		this.name = name;
	}
	
	@Override
	public String toString() {
		return "Student [id=" + id + ", name=" + name + "]";
	}
	
	// hashCode 비교 -> equals 확인 -> 동등
	@Override
	public int hashCode() {
		// 객체 식별값(정수)
		return id;
	}
	
	@Override
	public boolean equals(Object obj) {
		if(obj instanceof Student) {
			//다운 캐스팅
			Student other = (Student)obj;
			return name.equals(other.name)&&id==other.id;
		}
		return super.equals(obj);
	}
	
}
