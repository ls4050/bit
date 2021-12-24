package com.javaex.oop.point.v4;

public class PointApp {

	public static void main(String[] args) {
		Point p1 = new Point(10, 20);
		p1.draw();
		p1.draw(true);
		p1.draw(false);
		
		// 전체 필드 초기화 생성자 호출
		Point p2 = new Point(30, 40);
		p2.draw();
		p2.draw(true);
		p2.draw(false);
		
		ColorPoint cp1 = new ColorPoint(10, 20, "RED");
		cp1.draw(true);
		cp1.testP();
		
		// 다형성 : 부모타입으로 자식객체 참조
		Point cp2 = new ColorPoint(30, 40, "GREEN"); // 포인트에서 오바라이드 된 메서드가 아니라 컬러포인트에서 오바라이드 된 메서드호출
		cp2.draw(true);
		
		// Point에만 해당 메서드 있을 때는 정상작동
		// ColorPoint에만 해당 메서드 있을 때는 에러
		// 참조 타입의 메서드만 사용할 수 있기 때문.
		cp2.testP();
		
//		Point cp3 = new Point();
//		cp3.testP();
	}

}
