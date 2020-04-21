package com.bitongchong.classicalproblem;

/**
 * 冒泡排序：循环n次，每次都按顺序地对数组中的数进行两两比较，大的放后面，小的放前面，
 * 这样在一次循环之后，最大的数字就一定会放在数组的最后面，这样下一次循环的时候，
 * 就不循环这个数
 */
public class Code_1_1_BubbleSort {
    public static void bubbleSort1(int[] arr) {
        if (arr == null || arr.length == 1) {
            return;
        }
        // 此处是计算冒泡的次数，一共arr.length - 1次，因为最后一次只剩下一个数，这个数其实是已经排好序的
        for (int end = arr.length - 1; end > 0; end--) {
            // 除开排好序的尾部，再在剩下的数字中进行冒泡排序
            for (int i = 0; i < end; i++) {
                // 如果前一个数小于后一个数，则交换位置，当对数组中每一个数进行这步操作的时候，最大值一定会被交换在最后
                if (arr[i] > arr[i + 1]) {
                    // 注意：这个交换方式不能是交换自己，如果是交换自己的话，结果会成零。而可以交换两个相同的数
                    swap(arr, i, i + 1);
                }
            }
        }
    }

    public static void bubbleSort2(int[] arr) {
        boolean flag = false;
        if (arr == null || arr.length == 1) {
            return;
        }
        for (int end = arr.length - 1; end > 0; end--) {
            for (int i = 0; i < end; i++) {
                if (arr[i] > arr[i + 1]) {
                    swap(arr, i, i + 1);
                    flag = true;
                }
            }
            if (!flag)
                return;
            flag = false;
        }
    }

    public static void bubbleSort3(int[] arr) {
        int k = arr.length - 1;
        int flag = arr.length - 1;
        for (int end = k; end > 0; end--) {
            for (int i = 0; i < k; i++) {
                if (arr[i] > arr[i + 1]) {
                    swap(arr, i, i + 1);
                    flag = i;
                }
            }
            k = flag;
        }
    }
    // 这儿也可以将方法二的改进加进来

    // 这个是最终优化版
    public static void bubbleSort4(int[] arr) {
        boolean unfinish = false;
        int k = arr.length - 1;
        int flag = arr.length - 1;
        for (int end = k; end > 0; end--) {
            for (int i = 0; i < k; i++) {
                if (arr[i] > arr[i + 1]) {
                    swap(arr, i, i + 1);
                    flag = i;
                    unfinish = true;
                }
            }
            if (!unfinish) {
                return;
            }
            k = flag;
        }
    }

    public static void swap(int[] arr, int i, int j) {
        arr[i] = arr[i] ^ arr[j];
        arr[j] = arr[i] ^ arr[j];
        arr[i] = arr[i] ^ arr[j];
    }

    public static void main(String[] args) {
        int[] arr = {1, 3, 2, 4, 5, 6, 14545, -4744, 9, 58, 5, 11, 4545, 252, 2, 5};
        bubbleSort1(arr);
        for (int i : arr) {
            System.out.println(i);
        }
    }

}
