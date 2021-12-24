package com.javaex.oop.point.v3;

// v3. 메서드 오버라이딩
public class Point {
	private int x;
	private int y;

	// 기본 생성자: 매개변수가 없는
	public Point() {

	}

	// 전체 필드 초기화 생성자
	public Point(int x, int y) {
		this.x = x;
		this.y = y;
	}

	public int getX() {
		return x;
	}

	public void setX(int x) {
		this.x = x;
	}

	public int getY() {
		return y;
	}

	public void setY(int y) {
		this.y = y;
	}

	public void draw() {
		System.out.printf("점[x=%d, y=%d]을 그렸습니다.%n", x, y);
	}
	
	// 메서드 오버로딩
	// 매개변수 타입, 갯수, 순서가 같은 이름의 메서드를 중복 선언할 수 있다.
	public void draw(boolean bDraw) {
		String message = String.format("점[x=%d, y=%d]을 ", x,y);
		if(bDraw) { // == true
			message += "그렸습니다.";	
		} else { // ==false
			message += "지웠습니다.";
		}
		
		System.out.println(message);
	}
}
