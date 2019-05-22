package com.bitongchong.nowcodereview;


public class Code_06_MergeSort_SmallSum {

	public static int smallSum(int[] arr) {
		if (arr == null || arr.length < 2) {
			return 0;
		}
		return mergeSort(arr, 0, arr.length - 1);
	}

	public static int mergeSort(int[] arr, int left, int right) {
		if (left == right) {
			return 0;
		}
		int mid = left + ((right - left) >> 1); // 可以防止整数相加而溢出，但是要特别注意 >> 的优先级很低，需要加括号
		return mergeSort(arr, left, mid) + mergeSort(arr, mid + 1, right) + merge(arr, left, right, mid);
	}

	public static int merge(int[] arr, int left, int right, int mid) {
		int[] help = new int[right - left + 1];
		int z = 0;
		int res = 0;
		int p1 = left;
		int p2 = mid + 1;
		while (p1 <= mid && p2 <= right) {
			if (arr[p1] < arr[p2]) {
				res += arr[p1] < arr[p2] ? arr[p1] * (right - p2 + 1) : 0;
				help[z++] = arr[p1] < arr[p2] ? arr[p1++] : arr[p2++];
		} else {
				help[z++] = arr[p2++];// 注意等于的情况是在这儿
			}
		}
		while (p1 <= mid) {
			help[z++] = arr[p1++];
		}
		while (p2 <= right) {
			help[z++] = arr[p2++];
		}
		for (int t = 0; t < help.length; t++) {
			arr[left + t] = help[t];
		}
		return res;
	}
	public static void main(String[] args) {
		int[] arr = new int[] {1,2,4,10};
		System.out.println(smallSum(arr));
	}
	
}
