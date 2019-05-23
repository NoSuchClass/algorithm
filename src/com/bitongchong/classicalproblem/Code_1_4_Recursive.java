package com.bitongchong.classicalproblem;

//递归排序
public class Code_1_4_Recursive {
	public static int getMax(int left, int right, int[] arr) {
		if (right == left) {
			return arr[right];
		}
		// 递归循环的思路：将一个数据样本分为两份（也可以认为是执行两个不同的任务，这两个不同的任务里面又有着两个可以分开执行的不同的任务
		// 实质上就是一个入栈的过程，每次调用递归时，都会立即保存现场（包括变量值和未执行完的代码），等待递归调用返回的值。当调用返回值时，
		// 继续执行之前未执行完的代码（也可以看做是出栈的过程）。【需要注意的是，这个实例中的每一次的递归，除了终止条件满足，其他所有的过程
		// 所有的代码都是全部执行了的】这儿有个master公式，详细可以查看学习笔记
		// 简单点来说，其实就是相当于对最后一次递归得到的结果进行操作Math.max
		int mid = (right + left) >> 1;
		int leftMax = getMax(left, mid, arr);
		int rightMax = getMax(mid + 1, right, arr);
		return Math.max(leftMax, rightMax);
	}

	public static void main(String[] args) {
		int[] arr = new int[10];
		for (int i = 0; i < arr.length; i++) {
			arr[i] = (int) (100 * Math.random());
		}
		System.out.println(getMax(0, arr.length - 1, arr));
	}
}
