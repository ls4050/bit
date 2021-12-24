package com.javaex.sort;

class Sort {
	public void swap(int arr[], int i, int j ) {
		int temp = arr[i];
		arr[i] = arr[j];
		arr[j] = temp;
	}
	


	public void quick(int arr[], int l, int r) {
		int left = l;
		int right = r;
		int pivot = arr[(l+r)/2];
		
		//분할
		do {
			while(arr[left]<pivot) left++;
			while(arr[right]>pivot) right--;
			
			if(left<=right) {
				swap(arr, left, right);
				left++;
				right--;
			}
			
		} while(left<=right);
		
		// idx 0 ~ 가변변수 right
		if(l<right)quick(arr, l, right);
		
		// 가변변수 left ~ idx arr.length-1
		if(r>left)quick(arr, left, r);		
		
	}
	
	public void insertion(int arr[]) {
		for (int i = 1; i < arr.length; i++) {
			int target = arr[i];
			int j = i - 1;

			while (j >= 0 && target < arr[j]) {
				arr[j + 1] = arr[j];
				j--;
			}
			arr[j + 1] = target;
		}
		for (int i : arr)
			System.out.print(i + " ");
	}

	public void bubble(int arr[]) {
		int temp;
		int len = arr.length;
		for (int i = 0; i < len; i++) {
			for (int j = 0; j < len-1-i; j++) {
				if (arr[j] > arr[j + 1]) {
					temp = arr[j];
					arr[j] = arr[j + 1];
					arr[j + 1] = temp;
				}
			}
		}
		for (int i : arr)
			System.out.print(i + " ");
	}
}

public class SortApp {
	public static void main(String[] args) {
		int arr[] = new int[100];
		for (int i = 0; i < arr.length; i++) {
			arr[i] = (int) (Math.random() * 100) + 1;
		}
		Sort s = new Sort();

//		s.bubble(arr);
//		s.insertion(arr);
		s.quick(arr, 0, arr.length-1);
		for(int i=0; i<arr.length; i++) {
			System.out.print(arr[i] + " ");
		}
	}

}