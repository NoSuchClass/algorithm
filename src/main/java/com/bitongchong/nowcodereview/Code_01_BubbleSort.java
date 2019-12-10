package com.bitongchong.nowcodereview;

public class Code_01_BubbleSort {
	public static void main(String[] args) {
		int[] arr = new int[] { 2, 1, 3, 4, 8, 2 };
		sortFunc1(arr);
		for (int i : arr) {
			System.out.println(i);
		}
	}

	public static void sortFunc1(int[] arr) {
		if (arr == null || arr.length == 0) {
			return;
		}
		for (int i = arr.length - 1; i > 0; i--) {
			for (int j = 0; j < i; j++) {
				if (arr[j] > arr[j + 1]) {
					swap(arr, j + 1, j);
				}
			}
		}
	}

	public static void sortFunc2(int[] arr) {
		if (arr == null || arr.length == 0) {
			return;
		}
		boolean flage = false;
		for(int i = arr.length - 1; i > 0; i --) {
			for(int j = 0; j < i; j++) {
				if (arr[j] > arr[j + 1]) {
					swap(arr, j + 1, j);
					flage = true;
				}
			}
			if (!flage) {
				return;
			}
		}
	}

	public static void sortFunc3(int[] arr) {
		if (arr == null || arr.length == 0) {
			return;
		}
		int flage = arr.length - 1;
		while (flage > 0) {
			int end = flage;
			flage = 0;
			for (int j = 0; j < end; j++) {
				if (arr[j] > arr[j + 1]) {
					swap(arr, j + 1, j);
					flage = j;
				}
			}
		}
	}

	private static void swap(int[] arr, int i, int j) {
		arr[i] = arr[i] ^ arr[j];
		arr[j] = arr[i] ^ arr[j];
		arr[i] = arr[i] ^ arr[j];
	}
}
