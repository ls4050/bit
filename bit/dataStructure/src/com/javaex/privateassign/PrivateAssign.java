package com.javaex.privateassign;

import java.util.Arrays;
import java.util.Scanner;

public class PrivateAssign {

	private static void first() {
		Scanner sc = new Scanner(System.in);
		String input = sc.nextLine();
		int[] arr = new int[input.length()];
		for (int i = 0; i < input.length(); i++)
			arr[i] = input.charAt(i) - '0';
		Arrays.sort(arr);

		int count = 0;

		for (int i = 0; i < arr.length; i++) {
			if (arr[i] == 0)
				count++;
		}

		if (count == 0) {
			System.out.printf("%d%d%d%d", arr[0], arr[1], arr[2], arr[3]);
		} else if (count == 1) {
			arr[0] = arr[1];
			arr[1] = 0;
			System.out.printf("%d%d%d%d", arr[0], arr[1], arr[2], arr[3]);
		} else if (count == 2) {
			arr[0] = arr[2];
			arr[2] = 0;
			System.out.printf("%d%d%d%d", arr[0], arr[1], arr[2], arr[3]);
		} else if (count == 3) {
			arr[0] = arr[3];
			arr[3] = 0;
			System.out.printf("%d%d%d%d", arr[0], arr[1], arr[2], arr[3]);
		}
	}

	private static void second() {
		Scanner sc = new Scanner(System.in);

		System.out.print("Input X Number : ");
		int start = sc.nextInt();
		System.out.print("Input Y Number : ");
		int end = sc.nextInt();

		int count = 0;

		for (int i = start; i <= end; i++) {
			if (asc(i)) {
				count++;
				System.out.print(i + " ");
			}
		}
		System.out.println();
		System.out.println("count : " + count);
	}

	private static boolean asc(int n) {
		String s = Integer.toString(n);
		for (int i = 1; i < s.length(); i++) {
			if (s.charAt(i - 1) >= s.charAt(i))
				return false;
		}
		return true;
	}

	private static void third() {
		Scanner sc = new Scanner(System.in);

		while(true) {
			boolean run = false, triplete = false;
			System.out.print("Input 6 Numbers : ");
			String num = sc.next();
			int checkArr[] = new int[12];
			int tripcnt = 0, runcnt = 0, runcnt2 = 0;
			for (int i = 0; i < num.length(); i++) {
				checkArr[num.charAt(i) - '0']++;
			}
			for (int i = 0; i < checkArr.length; i++) {
				// triplete check
				if(checkArr[i]==6) {
					checkArr[i] -=6;
					tripcnt=2;
				} else if (checkArr[i] >= 3) {
					checkArr[i] -= 3;
					tripcnt++;
				}
				// run check
				if (checkArr[i] == 1 && checkArr[i + 1] == 1 && checkArr[i + 2] == 1) {
					runcnt++;
				} else if (checkArr[i] == 2 && checkArr[i + 1] == 2 && checkArr[i + 2] == 2) {
					runcnt2++;
				}

			}

			if (runcnt >= 2 || tripcnt >= 2 || runcnt + tripcnt >= 2 || runcnt2 == 1) {
				System.out.println("Baby-Jin!!!!");
				
			}
			else {
				System.out.println("Lose");
				
			}

			System.out.print("Play the game again? <1-yes/2-no> :");
			int select = sc.nextInt();
			if (select == 2)
				break;
		}
	}

	public static void main(String[] args) {
//		first();
//		second();
		third();
	}
}