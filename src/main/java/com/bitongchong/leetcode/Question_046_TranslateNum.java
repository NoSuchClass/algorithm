package com.bitongchong.leetcode;

import java.util.ArrayList;
import java.util.List;

/**
 * @author liuyuehe
 * @date 2020/6/9 23:33
 */
public class Question_046_TranslateNum {
    public int translateNum(int num) {
        if (num == 0) {
            return 0;
        }
        if (num / 10 == 0) {
            return 1;
        }
        List<Integer> list = new ArrayList<>();

        while(num != 0) {
            list.add(num % 10);
            num = num / 10;
        }
        int[] arr = new int[list.size()];
        for (int i = list.size(); i > 0; i--) {
            arr[list.size() - i] = list.get(i - 1);
        }
        int left = 1;
        int res = 1;
        for (int i = 1; i < arr.length; i++) {
            if (arr[i] + arr[i - 1] * 10 <= 25 && arr[i - 1] != 0) {
                int temp = res;
                res += left;
                left = temp;

            }
        }
        return res;
    }
    public static void main(String[] args){
        System.out.println(new Question_046_TranslateNum().translateNum(10332542));
    }
}
