package com.bitongchong.nowcodereview;

//在经典快排的基础上引入了随机快排，同时返回分界区域而非分界点
public class Code_10_QuickSort_Plus {
	public static void sortFunc(int[] arr) {
		int L = 0;
		int R = arr.length - 1;
		quickSort(arr, L, R);
	}
	
	public static void quickSort(int[] arr, int L, int R) {
		if (L < R) {
			int[] p = partition(arr, L, R);
			quickSort(arr, L, p[0] - 1);
			quickSort(arr, p[1] + 1, R);
		}
	}
	
	public static int[] partition(int[] arr, int L, int R) {
		int start = L - 1;
		int end = R;
		swap(arr, (int)(Math.random()*(R - L + 1)), R); //随机快排和经典快排的不同之处，可以较好地解决数据状况与算法时间复杂度有关的问题
		while(L < end) {
			if (arr[L] < arr[R]) {
				swap(arr, L++, ++start);
			}else if (arr[L] > arr[R]) {
				swap(arr, L, --end);
			}else {
				L++;
			}
		}
		swap(arr, R, end);
		return new int[] {start + 1, end};
	}

	public static void swap(int[] arr, int i, int j) {
		int temp = arr[i];
		arr[i] = arr[j];
		arr[j] = temp;
	}

	public static void main(String[] args) {
		int[] arr = new int[] { 45, 245, 0, -2145, 57, 3, 3, 3, 3, 3, 12, 43, 524, 36, 25, 625, 7 };
		sortFunc(arr);
		for (int i : arr) {
			System.out.println(i);
		}
	}
}
