package com.bitongchong.test;

public class Solution {
    /**
     * 刘悦河
     * @param 201603653
     */
    public static void main(String [] args){
        int [] randArr = new int[]{7,8,58,877,54,52,1};
        int result = findMinK(randArr, 0, randArr.length - 1, 4);
        System.out.print(result);
    }

    public static int findMinK(int [] arr, int low, int high, int k){
        int index = func(arr, low, high);
        if(index == k) return arr[index];
        if(index < k){
            return findMinK(arr, index + 1, high, k);
        }else{
            return findMinK(arr, low, index - 1, k);
        }
    }

    public static int func(int [] arr, int left, int right){
        while(left < right){
            while(left < right && arr[left] <= arr[right]){
                right--;
            }
            if(left < right){
                swap(arr, left, right);
                left++;
            }
            while(left < right && arr[left] <= arr[right]){
                left++;
            }
            if(left < right){
                swap(arr, left, right);
                right--;
            }
        }
        return left;
    }

    public static void swap(int[] arr, int left, int right){
        int tmp = arr[left];
        arr[left] = arr[right];
        arr[right] = tmp;
    }
}
