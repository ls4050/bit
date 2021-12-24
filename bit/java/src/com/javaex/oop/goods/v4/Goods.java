package com.javaex.oop.goods.v4;

//	v4 : this
// this : 현재 인스턴스 자체
// this() : 현재 클래스 내의 다른 생성자 호출
public class Goods {
	// 필드
	private String name;
	private int price;

	// 생성자 1.
	public Goods(String name) {
		this.name = name;
	}

	// 생성자 2.
	public Goods(String name, int price) {
		this(name); // 다른 생성자 호출
		this.price = price;
	}

	// 외부 접근 방식 노출
	// getter/setter
	public String getName() {
		return name;
	}

	// setter가 없으면 ReadOnly
	public void setName(String name) {
		this.name = name; // 현재 인스턴스의 네임값에 바깥의 name값을 넣는다
	}

	public int getPrice() {
		return price;
	}

	public void setPrice(int price) {
		this.price = price; // 현재 인스턴스의 price값에 바깥에서 전달된 인자값을 넣는다.
	}

	public void showInfo() {
		System.out.println("상품명:" + name);
		System.out.println("가격:" + price);
	}
}
