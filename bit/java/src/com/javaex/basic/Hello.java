package com.javaex.basic;

public class Hello {
	public static void main(String[] args) {
		String S1 = "Java";
		String S2 = new String("Java");
		String S3 = "Java";
		
		boolean result = S1==S2 ? true : false;
		
		System.out.println(result);
	}
}