package com.javaex.sort;

import java.util.Arrays;

public class Bubble {
	static final int data[] = new int[] { 90, 78, 100, 30, 55, 1234, 324 };
	static int len = data.length;
	
	private static void f(int arr[]) {
		int temp;
		for (int i = len-1; i >= 0; i--) {
			if (i == 0)
				break;
			if (data[i] < data[i - 1]) {
				temp = data[i];
				data[i] = data[i - 1];
				data[i - 1] = temp;
			}
			System.out.println(Arrays.toString(data));
		}
		
		len--;
	}

	public static void main(String[] args) {
		for (int i = 0; i < data.length / 2 + 1; i++) {
			f(data);
		}
	}
}