package com.javaex.binary;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Arrays;

public class BinarySearch {
	static int count =0;
	private static int sort(int[] arr, int l, int r, int find) {
		if (l > r)
			return -1;
		
		count++;
		int mid = l + (r - l) / 2;

		if (arr[mid] == find) {
			return mid;
		} else if (arr[mid] < find) {
			return sort(arr, mid + 1, r, find);
		} else {
			return sort(arr, l, mid - 1, find);
		}
	}

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int find = Integer.parseInt(br.readLine());

		int arr[] = new int[100];
		for (int i = 0; i < arr.length; i++) {
			arr[i] = (int) (Math.random() * 500) + 1;
		}
		
		
		if (sort(arr, 0, arr.length - 1, find) > 0) {
			System.out.println(sort(arr, 0, arr.length - 1, find) + 1);
			System.out.println("연산수 : " + count);
		} else {
			System.out.println("X");
			System.out.println("연산수 : " + count);
		}

	}

}