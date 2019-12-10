package com.bitongchong.nowcodereview;

public class Code_08_NetherlandsFlag {
	public static void sortFunc(int[] arr, int num) {
		int start = -1;
		int end = arr.length;
		int cur = 0;
		while (cur < end) {
			if (arr[cur] < num) {
				swap(arr, ++start, cur++);
			} else if (arr[cur] > num) {
				swap(arr, cur, --end);
			} else {
				cur++;
			}
		}
	}

	public static void swap(int[] arr, int i, int j) {
		int temp = arr[i];
		arr[i] = arr[j];
		arr[j] = temp;
	}

	public static void main(String[] args) {
		int[] arr = new int[] { 45, 245, 0, -2145, 57, 3, 3, 3, 3, 3, 12, 43, 524, 36, 25, 625, 7 };
		sortFunc(arr, 3);
		for (int i : arr) {
			System.out.println(i);
		}
	}
}
