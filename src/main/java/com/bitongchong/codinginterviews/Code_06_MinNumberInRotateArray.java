package com.bitongchong.codinginterviews;

/*
 * 题目描述：
把一个数组最开始的若干个元素搬到数组的末尾，我们称之为数组的旋转。 
输入一个非减排序的数组的一个旋转，输出旋转数组的最小元素。 
例如数组{3,4,5,1,2}为{1,2,3,4,5}的一个旋转，该数组的最小值为1。 

NOTE：给出的所有元素都大于0，若数组大小为0，请返回0。
 * 
 */

/**
 * @author liuyuehe
 * @description 比如1 2 3 4 5 6，在按照提意旋转之后，实际上是前半部分是递增的，后半部分是递减的
 * 在多旋转几次后就会发现，比如3 4 5 2 1这种，只要发现mid比right大，那么这一部分就是递减的，那么
 * 不管中间数据情况如何，最小值一定在这个区域范围内
 */
public class Code_06_MinNumberInRotateArray {
    public int minNumberInRotateArray(int[] array) {
        if (array.length == 0) {
            return 0;
        }
        int left = 0;
        int right = array.length - 1;
        int mid = (left + right) / 2;
        //如果前中后的大小相同，那么会存在几种情况，最小值可能在前面，也可能在后面。所以需要循环遍历出结果来
        if (array[left] == array[right] && array[left] == array[mid]) {
            for (int value : array) {
                if (value < mid) {
                    return value;
                }
            }
            return array[mid];
        }
        //如果大小不同，那么用二分查找就可也很快找出答案，注意判断条件，如果只剩下两个数，因为我们一直是找的递减的那一方的数组，
        // 因此最后两个数，一定是前一个数大于后一个数，因此如果剩下两个数是7 1 这样的数，那么将会一直死循环，并且返回的时候一定先
        // 返回右边的那一个数
        while ((left + 1) != right) {
            mid = (left + right) / 2;
            if (array[mid] <= array[right]) {
                right = mid;
            } else {
                left = mid;
            }
        }
        return array[right];
    }
}
