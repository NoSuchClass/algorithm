package com.bitongchong.classicalproblem;
//本程序解决的问题：

//小和问题：在一个数组中，每一个数左边比当前数小的数累加起来，叫做这个数组的小和。求一个数组的小和。

public class Code_1_5_2_MergeSort {
	public static int mergeSort(int[] arr) {
		if (arr == null || arr.length < 2) {
			return 0;
		} else {
			int left = 0;
			int right = arr.length - 1;
			return mergeSort(arr, left, right);
		}
	}

	public static int mergeSort(int[] arr, int left, int right) {
		int mid = left + ((right - left) >> 1);
		if (left == right) {
			return 0;
		}
		return mergeSort(arr, left, mid) + mergeSort(arr, mid + 1, right) + merge(arr, left, mid, right);
	}

	public static int merge(int[] arr, int left, int mid, int right) {
		int res = 0;
		int i = 0;
		int p1 = left;
		int p2 = mid + 1;
		int[] help = new int[right - left + 1];
		while (p1 <= mid && p2 <= right) {
			res += arr[p1] < arr[p2] ? arr[p1] * (right - p2 + 1) : 0;
			help[i++] = arr[p1] < arr[p2] ? arr[p1++] : arr[p2++];
		}
		// 当上面一个while不满足时，说明分开的两个数组有一个越界或者说是全部进入了help数组
		// 那么另外一个数组必然没有越界，或者刚好到达边界，那么直接将这一部分尽数放入help数组中便可
		while (p1 <= mid) {
			help[i++] = arr[p1++];
		}
		while (p2 <= right) {
			help[i++] = arr[p2++];
		}
		for (int j = 0; j < help.length; j++) {
			// 配合可变的help数组进行copy
			arr[left++] = help[j];
		}
		return res;
	}

	public static void main(String[] args) {
		int[] arr = new int[] {1,2,4,0};
		System.out.println(mergeSort(arr));
	}
}
