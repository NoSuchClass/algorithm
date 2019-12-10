package com.bitongchong.nowcodereview;

public class Code_05_MergeSort_Original {
	public static void sortFunc(int[] arr) {
		if (arr == null || arr.length < 2) {
			return;
		}
		mergeSortFunc(arr, 0, arr.length - 1);
	}

	public static void mergeSortFunc(int[] arr, int left, int right) {
		if (left == right) {
			return;
		}
		int mid = (left + right) >> 1;
		mergeSortFunc(arr, left, mid);
		mergeSortFunc(arr, mid + 1, right);
		merge(arr, left, right, mid);
	}

	public static void merge(int[] arr, int left, int right, int mid) {
		int[] help = new int[right - left + 1];
		int k = 0;
		int i = left;
		int j = mid + 1;
		while(i <= mid && j <=right) {
			help[k++] = arr[i] > arr[j] ? arr[j++] : arr[i++];
		}
		while(i <= mid) {
			help[k++] = arr[i++];
		}
		while(j <= right) {
			help[k++] = arr[j++]; 
		}
		for(int l = 0; l < help.length; l++) {
			arr[left + l] = help[l];
		}
	}

	public static void main(String[] args) {
		int[] arr = new int[] {1,2,4,1,3,645734,3,524,52,45,246,24,6,6,-124,-9,-0};
		sortFunc(arr);
		for (int i : arr) {
			System.out.println(i);
		}
	}
}
