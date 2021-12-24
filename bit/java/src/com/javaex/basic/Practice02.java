package com.javaex.basic;

import java.util.Arrays;
import java.util.Scanner;

public class Practice02 {

	public static void main(String[] args) {
//		problem01();
//		problem02();
//		problem03();
//		problem04();
		problem05();
	}

	private static void problem01() {
		int[] data = { 1, 3, 5, 8, 9, 11, 15, 19, 18, 20, 30, 33, 31 };
		int count = 0, sum = 0;
		for (int i = 0; i < data.length; i++) {
			if (data[i] % 3 == 0) {
				count++;
				sum += data[i];
			}
		}
		System.out.println("주어진 개수에서 3의 배수의 개수=>" + count);
		System.out.println("주어진 배열에서 3의 배수의 합=>" + sum);
	}

	private static void problem02() {
		Scanner sc = new Scanner(System.in);
		int sum = 0, count = 0;
		int arr[] = new int[5];
		
		for (int i = 0; i < 5; i++) {
			int num = sc.nextInt();
			arr[i] = num;
			count++;
			sum += arr[i];
		}
		System.out.println("평균은 "+(float)(sum/count)+" 입니다.");
	}
	
	private static void problem03() {
		char c[] = {'T', 'h', 'i', 's', ' ', 'i', 's', ' ', 'a', ' ', 'p', 'e', 'n', 'c', 'i', 'l'};
		
		for(int j=0; j<c.length; j++) System.out.print(c[j]);
		System.out.println();
		for(int i=0; i<c.length; i++)
		{
			if(c[i] == ' ') {
				System.out.print(',');
			} else {
				System.out.print(c[i]);	
			}
		}
//		System.out.println(Arrays.toString(c));
//		System.out.println(c[1]);
		
	}
	
	private static void problem04() {
		int arr[] = new int[7];
		for(int i=0; i<7; i++)
		{
			arr[i]=(int)(Math.random()*45+1);
			if(arr[i]!=arr[arr.length-1]) System.out.printf("%d\t", arr[i]);
			else continue;
		}
	}
	
	private static void problem05() {
		int scoreboard[][] = {
				{80,75,90,95,78},
				{92,88,89,92,70},
				{78,80,85,86,63},
				{83,84,89,87,75},
				{89,83,93,94,78}
		};
		int sum=0, count=0;
		for(int i=0; i<scoreboard.length;i++) {
			for(int j=0; j<scoreboard[i].length;j++) {
				if(scoreboard[i][j]>=85) {
					sum+=scoreboard[i][j];
					count++;
				}
			}
		}
		System.out.println("총합 : "+ sum);
		System.out.println("평균 : "+ sum/count);
	}
}

