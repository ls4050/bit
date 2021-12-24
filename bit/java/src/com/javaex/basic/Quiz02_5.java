package com.javaex.basic;

public class Quiz02_5 {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		int num1 = 13579;
		int num2 = 13579;
		// 다음 두 값이 같은지 확인하는 코드를 작성해 봅시다. 같다면 "같음" 다르다면 "다름"을 출력하세요.
		// ++num1 + 1
		// num2++ + 1

		

		boolean r = (++num1+1==num2++ + 1) ? true : false;

		System.out.println(r);
	}

}
