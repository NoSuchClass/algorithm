package com.bitongchong.nowcodereview;

public class Code_04_Recursive {
	public static int findMax(int[] arr, int left, int right) {
		if (left == right) {
			return arr[left];
		}
		int mid = (left + right) >> 1;
		int leftMax = findMax(arr, left, mid);
		int rightMax = findMax(arr, mid + 1, right);
		return Math.max(rightMax, leftMax);
	}

	public static void main(String[] args) {
		int[] arr = new int[] { 1, 325, 5, 57, 45, 34,99999,43634576,547,4,687,65,856,78,5678,567,3,67,235,62345,7,3456,456,78 };
		System.out.println(findMax(arr, 0, arr.length - 1));
	}

}
