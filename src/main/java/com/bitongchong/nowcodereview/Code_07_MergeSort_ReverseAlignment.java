package com.bitongchong.nowcodereview;

public class Code_07_MergeSort_ReverseAlignment {

	public static void smallSum(int[] arr) {
		if (arr == null || arr.length < 2) {
			return;
		}
		mergeSort(arr, 0, arr.length - 1);
	}

	public static void mergeSort(int[] arr, int left, int right) {
		if (left == right) {
			return;
		}
		int mid = left + ((right - left) >> 1); // 可以防止整数相加而溢出，但是要特别注意 >> 的优先级很低，需要加括号
		mergeSort(arr, left, mid);
		mergeSort(arr, mid + 1, right);
		merge(arr, left, right, mid);
	}

	public static void merge(int[] arr, int left, int right, int mid) {
		int[] help = new int[right - left + 1];
		int z = 0;
		int p1 = left;
		int p2 = mid + 1;
		while (p1 <= mid && p2 <= right) {
			if (arr[p1] > arr[p2]) {
				help[z++] = arr[p1++];
				for (int j = p2; j <= right; j++) {
					System.out.println(arr[p1 - 1] + " and " + arr[j]); // 因为p1的序号变化了的，所以这儿需要减个一
				}
			} else {
				help[z++] = arr[p2++];
			}
		}
		while (p1 <= mid) {
			help[z++] = arr[p1++];
		}
		while (p2 <= right) {
			help[z++] = arr[p2++];
		}
		for (int j = 0; j < help.length; j++) {
			arr[left + j] = help[j];
		}
		return;
	}

	public static void main(String[] args) {
		int[] arr = new int[] { 1, 2, 4, 10, 1, 3, 4, 5, 1, 0, -1 };
		smallSum(arr);
		for (int i : arr) {
			System.out.println(i);
		}
	}
}
