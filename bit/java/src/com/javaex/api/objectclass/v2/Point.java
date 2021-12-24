package com.javaex.api.objectclass.v2;

//v2. equals
public class Point {
	private int x;
	private int y;

	public Point(int x, int y) {
		this.x = x;
		this.y = y;
	}
	
	@Override
	public String toString() {
		// 객체 문자열 포맷을 반환
		return String.format("Point(%d, %d)", x, y);
	}

	@Override
	public boolean equals(Object obj) {
		if( obj instanceof Point) { //받아온 객체가 Point 객체라면
			// 변환
			Point other = (Point)obj;
			// 내가 가진 x 와 other가 가진 x
			// 내가 가진 y 와 other가 가진 y
			// 비교
			return x == other.x && y == other.y; 
		}
		return super.equals(obj);
	}
	
	
}
