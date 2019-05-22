package com.bitongchong.nowcode;

//本程序解决问题：运用归并进行排序
public class Code_1_5_1_MergeSort {
	// 归并排序思路：将数组一分为二，每一部分分别排好序，然后通过外排的方式分别向辅助数组中添加数据，
	// 当一个数组所有数据都放完后，直接拷贝另一个数组剩下的元素，再将数组拷贝回原函数
	// 问题一、怎么给两个数组分别排好序
	// 解答：对最后一次递归调用的结果都进行排序操作，然后拷贝回原数组，这样慢慢出栈，就相当于对每个数值都进行了判断
	// 问题二、怎么判断一个数组的元素已经排完
	// 解答：用三个while来分别判断三种情况

	// 记得有一个说法是，假设前面的递归过程都正确，就看最后一步“治”应该怎么操作
	public static void mergeSort(int[] arr) {
		if (arr == null || arr.length == 1) {
			return;
		}
		mergeSort(arr, 0, arr.length - 1);
	}

	public static void mergeSort(int[] arr, int left, int right) {
		// 这样写可以防止int相加超出范围，同时加快速度
		int mid = left + ((right - left) >> 1);
		if (left == right) {
			return;
		}
		mergeSort(arr, left, mid);
		mergeSort(arr, mid + 1, right);
		merge(arr, left, mid, right);
	}

	public static void merge(int[] arr, int left, int mid, int right) {
		// 让help数组大小改变
		int[] help = new int[right - left + 1];
		int p1 = left;
		int p2 = mid + 1;
		int i = 0;
		// 判断分开的数组那个元素小更小一点的存入help数组，同时对应数组到下一位
		while (p1 <= mid && p2 <= right) {
			help[i++] = arr[p1] < arr[p2] ? arr[p1++] : arr[p2++];
		}
		while (p1 <= mid) {
			help[i++] = arr[p1++];
		}
		while (p2 <= right) {
			help[i++] = arr[p2++];
		}
		for (int j = 0; j < help.length; j++) {
			// 配合可变的help数组进行copy
			arr[left + j] = help[j];
		}
	}

	public static void main(String[] args) {
		int[] arr = new int[6];
		for (int i = 0; i < arr.length; i++) {
			arr[i] = (int) (1000 * Math.random());
		}
//		for (int i : arr) {
//			System.out.println(i);
//		}
		mergeSort(arr);
		for (int i : arr) {
			System.out.println(i);
		}
	}
}
