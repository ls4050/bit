package com.javaex.basic;

public class Quiz02_3 {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		int num = 13579;

		// num이 456이라면 결과는 400
		// num이 12345라면 결과는 12300이 됩니다.
		int result = num / 100 * 100;
		System.out.println(result);
	}

}
