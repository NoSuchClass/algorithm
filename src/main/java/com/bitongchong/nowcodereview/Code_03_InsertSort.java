package com.bitongchong.nowcodereview;

public class Code_03_InsertSort {
	public static void sortFunc(int[] arr) {
		if (arr == null || arr.length < 2) {
			return;
		}
		for (int i = 1; i < arr.length; i++) {
			for(int j = i - 1; j >= 0 && arr[j] > arr[j + 1]; j--) {
				swap(arr, j + 1, j);
			}
		}
	}
	public static void swap(int[] arr, int i, int j) {
		if (arr[i] == arr[j]) {
			return;
		}
		arr[i] = arr[i]^arr[j];
		arr[j] = arr[i]^arr[j];
		arr[i] = arr[i]^arr[j];
	}
	public static void main(String[] args) {
		int[] arr = new int[] {1,1,0,34567,43,78,34,123,6,7,45,23,67,3};
		sortFunc(arr);
		for (int i : arr) {
			System.out.println(i);
		}
	}
}
