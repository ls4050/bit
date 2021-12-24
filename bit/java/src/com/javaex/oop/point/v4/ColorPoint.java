package com.javaex.oop.point.v4;

// 상속과 override
public class ColorPoint extends Point {
	private String color;

	// 생성자
	public ColorPoint() {
		// 부모의 생성자를 먼저 불러오는데
		// 똑같은 인자를 가진 부모의 생성자가 존재하지 않으므로
		// 에러 발생
		// Sol) 부모 클래스에 같은 인자의 부모 생성자를 작성
	}

	public ColorPoint(int x, int y, String color) {
		super(x, y); // 부모 생성자 명시적으로 표시해줌
		this.color = color;
	}

	// private 으로 변수 선언시 super를 이용하여 getX getY 불러옴
//	public void draw(boolean bDraw) {
//		// 부모로부터 물려 받은 메서드를
//		// 덮어 쓰기
//		String message = String.format("색깔점[x=%d, y=%d, color=%d]을 ", super.getX(), super.getY(), color);
//		message += bDraw ? "그렸습니다." : "지웠습니다.";
//		
//		System.out.println(message);
//	}

	// 오버라이드시에
	// 부모함수에 static 붙으면 자식함수에도 static 붙여야한다
	public static void testP() {
		System.out.println("ColorPoint Methods");
//		super.testP();
	}

	// protected로 변수 선언 시 x,y 바로 불러올수 있음
	@Override // 컴파일러에게 이 메서드가 오버라이딩한 메서드인지를 확인
	public void draw(boolean bDraw) {
		// 부모로부터 물려 받은 메서드를
		// 덮어 쓰기
		String message = String.format("색깔점[x=%d, y=%d, color=%s]을 ", x, y, color);
		message += bDraw ? "그렸습니다." : "지웠습니다.";

		System.out.println(message);

		// 부모의 메서드를 호출하려면
		super.draw(bDraw);

		// 1. 부모 상속
		// 2.
	}
}
