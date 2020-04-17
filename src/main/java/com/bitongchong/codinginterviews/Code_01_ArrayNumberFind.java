package com.bitongchong.codinginterviews;

/*
 * 题目描述：
 * 在一个二维数组中（每个一维数组的长度相同），每一行都按照从左到右递增的顺序排序，
 * 每一列都按照从上到下递增的顺序排序。请完成一个函数，输入这样的一个二维数组和一个整数，
 * 判断数组中是否含有该整数。
 */
public class Code_01_ArrayNumberFind {
    public boolean Find(int target, int[][] array) {
        int n = array[0].length - 1;
        int m = 0;
        while (n >= 0 && m < array.length) {
            if (array[m][n] < target) {
                m++;
            } else if (array[m][n] > target) {
                n--;
            } else {
                return true;
            }
        }
        return false;
    }
}