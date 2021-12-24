package com.javaex.basic;

public class MainArgs {

	public static void main(String[] args) {
		// 프로그램 실행시 외부에서 전달되는 매개변수들
		System.out.println("매개변수의 갯수 : " + args.length);
		for (int i = 0; i < args.length; i++) {
			System.out.println("매개변수:" + args[i]);
		}
	}

}
