package com.bitongchong.classicalproblem;

/*
 * 实现快排
 */
public class Code_2_2_QuickSort {
	// 快速排序的思路：取数组中最后一位数，分别与数组中各个数进行比较，做到大的放右边，小的放左边
	// 最后将最后一位数放入数组中（这个时候整体是无序的）要做到整体有序，需要将另一半继续取最
	// 后一位，做为比较，递归，做到最后整体有序。
	// 这个问题可以通过荷兰国旗问题化简优化，即初始步骤和上面经典快排一样，但是中间有相等
	// 的数组时，不将其计入递归。

	// 结题步骤：
	// 1、使用归并法时，如何分组：在归并时，每次返回一个有两个参数的数组，数组中存放less与more的位置
	// 2、分组后如何完成排序：归并，每次选一个数作为比较值（默认为最后一个，也可以随机取），这样每一个都可以排好一个或多个
	// 3、结束条件是什么：每次都传入比比较值小的数和大的数，所以只需要等到L<R时，就可以结束了。让所有的操作都在while中进行

	// 这儿用了荷兰国旗问题来优化经典快排，核心就是少判断一些相同值
	public static void quickSort(int[] arr) {
		int left = 0;
		int right = arr.length - 1;
		quickSort(arr, left, right);
	}

	public static void quickSort(int[] arr, int left, int right) {
		// 这儿写while的话，为什么会死循环呢？
		// 现在的想法：因为递归需要一个结束条件，while和for类似，下面如果写while的话，其实就和while(1!=0)一样
		// 一直没有改变left和right的值，所以会陷入死循环。而if的话，它判断成立后，只需要运行一次就跳出。
		if (left < right) {
			swap(arr, left + (int) ((right - left + 1) * Math.random()), right);
			int[] p = patition(arr, left, right);
			quickSort(arr, left, p[0] - 1);
			quickSort(arr, p[1] + 1, right);
		}
	}

	public static int[] patition(int[] arr, int left, int right) {
		int less = left - 1;
		// 相当于把最后一位数作为比较数时，直接不参与比较，放到more队伍中
		// 这儿相当于是随机从数组中选一个数，和最后一位数进行交换，这样可以避免原本部分有序的数组不能实现二分的结果
		int more = right;
		while (left < more) {
			if (arr[left] < arr[right]) {
				swap(arr, left++, ++less);
			} else if (arr[left] > arr[right]) {
				swap(arr, left, --more);
			} else {
				left++;
			}
		}
		swap(arr, more, right);
		return new int[] { less + 1, more };
	}

	public static void swap(int[] arr, int i, int j) {
		int temp = arr[i];
		arr[i] = arr[j];
		arr[j] = temp;
	}

	public static void main(String[] args) {
		int[] arr = new int[40];
		for (int i = 0; i < arr.length; i++) {
			arr[i] = (int) (100 * Math.random());
			System.out.println(arr[i]);
		}
		quickSort(arr);
		System.out.println("结果");
		for (int i : arr) {
			System.out.println(i);
		}
	}

}
