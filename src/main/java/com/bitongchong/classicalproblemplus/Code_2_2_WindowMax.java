package com.bitongchong.classicalproblemplus;

import java.util.ArrayList;
import java.util.LinkedList;

/**239. 滑动窗口最大值
 * 给定一个数组 nums，有一个大小为 k 的滑动窗口从数组的最左侧移动到数组的最右侧。
 *  你只可以看到在滑动窗口 k 内的数字。滑动窗口每次只向右移动一位。
 *  返回滑动窗口最大值。
 *
 */
public class Code_2_2_WindowMax {
    public ArrayList<Integer> maxInWindows(int[] num, int size) {
        // 在向双端队列添加值的时候，需要遵从从头到尾由大到小的规则，每次添加一个数都是添加在双端队列的最后
        ArrayList<Integer> arr = new ArrayList<>();
        if (num == null || size > num.length || size < 1) return arr;
        LinkedList<Integer> maxList = new LinkedList<>();
        for (int i = 0; i < num.length; i++) {
            // 如果添加数字时，添加的数比最后一个数要大，那么由于它更晚过期，同时值也更加大，那么它前面的值都可以被抛出（注意此时判空条件）
            while (!maxList.isEmpty() && num[maxList.peekLast()] <= num[i]){
                maxList.pollLast();
            }
            maxList.add(i);
            // 同时也需要对没在窗口中的值进行一个是否失效的判断
            // 为什么是maxList.peekFirst()  == i - size呢？ 为什么不是while去掉多个过期数字呢？
            // 因为在添加数字的时候就注定了不可能存在后面的数字排在前面数字的前面的这种情况发生（后面数字排在前面的情况就只有后面的数字较大，然而在添加的时候
            // 如果后面数字较大时，会将前面更小的数字给去掉）
            if (maxList.peekFirst() == i - size){
                maxList.pollFirst();
            }
            // 在取最大值的时候也需要做一个判断，即只有当第一个窗口形成时，才开始接收窗口中最大值
            if (i >= size - 1){
                arr.add(num[maxList.peekFirst()]);
            }
        }
        return arr;
    }
}

/*
  思路： 遍历数组 L R 为滑窗左右边界 只增不减
        双向队列保存当前窗口中最大的值的数组下标 双向队列中的数从大到小排序，
        新进来的数如果大于等于队列中的数 则将这些数弹出 再添加
        当R-L+1=k 时 滑窗大小确定 每次R前进一步L也前进一步 保证此时滑窗中最大值的
        数组下标在[L，R]中，并将当前最大值记录
  举例： nums[1，3，-1，-3，5，3，6，7] k=3
     1：L=0，R=0，队列【0】 R-L+1 < k
            队列代表值【1】
     2: L=0,R=1, 队列【1】 R-L+1 < k
            队列代表值【3】
     解释：当前数为3 队列中的数为【1】 要保证队列中的数从大到小 弹出1 加入3
          但队列中保存的是值对应的数组下标 所以队列为【1】 窗口长度为2 不添加记录
     3: L=0,R=2, 队列【1，2】 R-L+1 = k ,result={3}
            队列代表值【3，-1】
     解释：当前数为-1 队列中的数为【3】 比队列尾值小 直接加入 队列为【3，-1】
          窗口长度为3 添加记录记录为队首元素对应的值 result[0]=3
     4: L=1,R=3, 队列【1，2，3】 R-L+1 = k ,result={3，3}
            队列代表值【3，-1,-3】
     解释：当前数为-3 队列中的数为【3，-1】 比队列尾值小 直接加入 队列为【3，-1，-3】
          窗口长度为4 要保证窗口大小为3 L+1=1 此时队首元素下标为1 没有失效
          添加记录记录为队首元素对应的值 result[1]=3
     5: L=2,R=4, 队列【4】 R-L+1 = k ,result={3，3，5}
            队列代表值【5】
     解释：当前数为5 队列中的数为【3，-1，-3】 保证从大到小 依次弹出添加 队列为【5】
          窗口长度为4 要保证窗口大小为3 L+1=2 此时队首元素下标为4 没有失效
          添加记录记录为队首元素对应的值 result[2]=5
    依次类推 如果队首元素小于L说明此时值失效 需要弹出
*/
