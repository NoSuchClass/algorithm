package com.bitongchong.classicalproblem;
//本程序解决的问题：

//逆序对问题:在一个数组中，左边的数如果比右边的数大，则这两个数构成一个逆序对，请打印所有逆序对。

public class Code_1_5_3_MergeSort {
	// 结题思路：将数组分为两块，分别求出两块数组的逆序对，然后求两块和在一起
	public static void merge(int[] arr) {
		// 应该是不考虑数组为空的情况
		if (arr.length == 1) {
			System.out.println(arr[0]);
		}
		int left = 0;
		int right = arr.length - 1;
		merge(arr, left, right);
	}

	public static void merge(int[] arr, int left, int right) {
		if (left == right) {
			return;
		}
		int mid = left + ((right - left) >> 1);
		merge(arr, left, mid);
		merge(arr, mid + 1, right);
		printRes(arr, left, mid, right);
	}

	public static void printRes(int[] arr, int left, int mid, int right) {
		int[] help = new int[right - left + 1];
		int count = 0;
		int p1 = left;
		int p2 = mid + 1;
		// 这儿是给一个辅助数组，然后逐次判断两个分开的数组谁更大，大一点的存入辅助数组
		// 并打印，同时将辅助数组拷贝会原数组
		while (p1 <= mid && p2 <= right) {
			if (arr[p2] >= arr[p1]) {
				help[count++] = arr[p2++];
			} else {
				help[count++] = arr[p1];
				int p3 = p2;
				while (p3 <= right) {
					System.out.println(arr[p1] + "," + arr[p3++]);
				}
				p1++;
			}
		}
		while (p1 <= mid) {
			help[count++] = arr[p1++];
		}
		while (p2 <= right) {
			help[count++] = arr[p2++];
		}
		for (int j = 0; j < help.length; j++) {
			arr[left++] = help[j];
		}
	}

	public static void main(String[] args) {
		int[] arr = new int[40000];
		for (int i = 0; i < arr.length; i++) {
			arr[i] = (int) (100 * Math.random());
			System.out.print(arr[i] + " ");
		}
		System.out.println("");
		merge(arr);
	}
}
