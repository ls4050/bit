package com.javaex.api.objectclass.v1;
//자바 최상위 클래스는 Object
public class Point {
	private int x;
	private int y;
	
	public Point(int x, int y) {
		this.x = x;
		this.y = y;
	}
	
	public String toString() {
		// 객체 문자열 포맷을 반환
		return String.format("Point(%d, %d)", x, y);
	}
}
