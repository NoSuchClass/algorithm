package com.bitongchong.leetcode;

import java.util.ArrayList;
import java.util.List;

/**
 * @author liuyuehe
 * @date 2020/4/24 11:04
 */
public class Code_120_Triangle {
    public int minimumTotal1(List<List<Integer>> triangle) {
        if (triangle == null || triangle.size() == 0 || triangle.get(0).size() == 0) {
            return 0;
        }
        // 这个容量大小的原因是，triangle数组是三角形，最后一层元素个数等于层数
        int[] dp = new int[triangle.size()];
        dp[0] = triangle.get(0).get(0);
        // 这儿的cur、pre都是正在查看的元素的上一层对应的那个和前一个元素
        // 比如：
        // [3, 4]
        // [6, 5, 7]，这儿的cur和pre在5这个地方，分别是指4和3
        int cur, pre = dp[0];
        for (int i = 1; i < triangle.size(); i++) {
            // 看一下修改list中的元素，triangle中的元素是否变化：会变化的，记住了
            List<Integer> list = triangle.get(i);
            for (int j = 0; j < list.size(); j++) {
                cur = dp[j];
                if (j == 0) {
                    dp[j] = dp[j] + list.get(j);
                } else if (j == list.size() - 1) {
                    dp[j] = pre + list.get(j);
                } else {
                    dp[j] = Math.min(cur, pre) + list.get(j);
                }
                pre = cur;
            }
        }
        int res = Integer.MAX_VALUE;
        for (int value : dp) {
            res = Math.min(res, value);
        }
        return res;
    }

    /**
     * 实际上，也可以使用从底部到顶部的方法来解题，并且这种方式更为简单方便，因为从底到顶，在保存好上一层的所有元素位置的最短路径之后，
     * 在新的一层的某个元素（比如j这个位置），只需要取到dp[j]和dp[j - 1]这两个位置的元素就能够得到当前位置路径最小值，因为从底到顶元
     * 素个数是不断减少的，因此到顶部的时候，就只剩下一个元素的最短路径了，因此，直接对这个元素进行返回，就是最终的答案这种放发的好处
     * 是，不需要设置cur和pre这两个临时变量来避免因为元素增多而导致的新元素覆盖旧元素，同时也没有j==0和j==list.size()-1的这
     * 两种特殊情况
     * @param triangle -
     * @return -
     */
    public int minimumTotal(List<List<Integer>> triangle) {
        if (triangle == null || triangle.size() == 0 || triangle.get(0).size() == 0) {
            return 0;
        }
        int[] dp = new int[triangle.size()];
        for (int i = 0; i < dp.length; i++) {
            dp[i] = triangle.get(triangle.size() - 1).get(i);
        }
        for (int i = triangle.size() - 2; i >= 0; i--) {
            List<Integer> curList = triangle.get(i);
            for (int j = 0; j < curList.size(); j++) {
                dp[j] = Math.min(dp[j], dp[j + 1]) + curList.get(j);
            }
        }
        return dp[0];
    }

    public static void main(String[] args){
        List<Integer> element1 = new ArrayList<>();
        element1.add(2);
        List<Integer> element2 = new ArrayList<>();
        element2.add(3);
        element2.add(4);
        List<Integer> element3 = new ArrayList<>();
        element3.add(6);
        element3.add(5);
        element3.add(7);
        List<Integer> element4 = new ArrayList<>();
        element4.add(4);
        element4.add(1);
        element4.add(8);
        element4.add(3);
        List<List<Integer>> triangle = new ArrayList<>();
        triangle.add(element1);
        triangle.add(element2);
        triangle.add(element3);
        triangle.add(element4);
        System.out.println(new Code_120_Triangle().minimumTotal(triangle));
    }
}
