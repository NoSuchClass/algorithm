package com.bitongchong.nowcode;
//解决问题：给定一个数组arr，和一个数num，请把小于num的数放在数组的左边，等于num的数放在数组的中间，大于num的数放在数组的右边。
//要求额外空间复杂度O(1)，时间复杂度O(N)
public class Code_2_1_HollandFlagProblem {
	public static void sortFunc(int[] arr, int num) {
		int start = -1;
		int end = arr.length;
		int cur = 0;
		while (cur < end) {
			if (arr[cur] < num) {
				swap(arr, ++start, cur++);
				start++;
			} else if (arr[cur] > num) {
				swap(arr, cur, --end);
				end--;
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
