package com.javaex.basic;

public class Quiz02_2 {
	public static void main(String[] args) {
		int balls = 136;
		int cap = 10;

		int result = balls / cap == 0 ? balls / cap : balls / cap + 1;

		System.out.println(result);
	}
}
