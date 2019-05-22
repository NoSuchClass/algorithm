package com.bitongchong.nowcodereview;

public class Code_02_SelectSort {
	public static void sortFunc(int[] arr) {
		if (arr == null || arr.length < 2) {
			return;
		}
		for(int i = 0; i < arr.length - 1; i++) {
			int minIndex = i;
			for(int j = i + 1; j < arr.length; j++) {
				minIndex = arr[minIndex] > arr[j] ? j : minIndex;
			}
			swap(minIndex, i, arr);
		}
	}

	private static void swap(int minIndex, int i, int[] arr) {
		if (i == minIndex) {
			return;
		}
		arr[i] = arr[minIndex] ^ arr[i];
		arr[minIndex] = arr[minIndex] ^ arr[i];
		arr[i] = arr[minIndex] ^ arr[i];
	}

	public static void main(String[] args) {
		int[] arr = new int[6];
		for (int i = 0; i < arr.length; i++) {
			arr[i] = (int) (1000 * Math.random());
		}
		sortFunc(arr);
		for (int i : arr) {
			System.out.println(i);
		}
	}
}
