package com.javaex.api.objectclass.v3;

public class LangClassTest {

	public static void main(String[] args) {
		Point p = new Point(10, 10);
		int[] arr = new int[4];
		int[] r = arr.clone();
		// 배열복제는 그냥 써도된다
		// 객체복제하기위해서는 직접 오버라이딩해서 복제해야한다
		
		System.out.println("p=" + p);

//		Point p2 = (Point)p.clone(); // 오브젝트 복제
		Point p2 = p.getClone(); // 오브젝트 복제
		System.out.println("p2=" + p2);
		System.out.println(p2==p); // 주소 값도 다르므로 완벽한 복제가 된 것
		
		p.setX(100);
		p.setY(200);
		
		System.out.println("p=" + p); // p의 값을 바꿔도 p2는 영향 받지 않는다
		System.out.println("p2=" + p2);
	}

}
