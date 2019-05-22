package com.bitongchong.codinginterviews;

/*
 * 题目描述：
把一个数组最开始的若干个元素搬到数组的末尾，我们称之为数组的旋转。 
输入一个非减排序的数组的一个旋转，输出旋转数组的最小元素。 
例如数组{3,4,5,1,2}为{1,2,3,4,5}的一个旋转，该数组的最小值为1。 

NOTE：给出的所有元素都大于0，若数组大小为0，请返回0。
 * 
 */

public class Code_04_MinNumberInRotateArray {
    public int minNumberInRotateArray(int [] array) {
        if(array.length == 0){
            return 0;
        }
        int left = 0;
        int right = array.length - 1;
        int mid = (left + right)/2;
        //如果前中后的大小相同，那么会存在几种情况，最小值可能在前面，也可能在后面。所以需要循环遍历出结果来
        if(array[left] == array[right] && array[left] == array[mid]){
            for(int i = 0; i < array.length; i++){
                if(array[i] < mid){
                    return array[i];
                }
            }
            return array[mid];
        }
        //如果大小不同，那么用二分查找就可也很快找出答案
        while((left + 1) != right){
            mid = (left + right)/2;
            if(array[mid] <= array[right]){
                right = mid;
            }else{
                left = mid;
            }
        }
        return array[right];
    }
}
