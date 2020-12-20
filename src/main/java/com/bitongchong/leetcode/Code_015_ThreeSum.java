package com.bitongchong.leetcode;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * @author liuyuehe
 * @description 三数之和 ： 这道题的主要难点在于去重
 * @date 2019/12/3
 */
public class Code_015_ThreeSum {
//    public static void main(String[] args) {
//        List<List<Integer>> lists = new Code_015_ThreeSum().threeSum(new int[]{0, 0, 0, 2, -1, -3323});
//        for (List<Integer> integers :
//                lists) {
//            System.out.println(integers);
//        }
//
//    }

    public List<List<Integer>> threeSum(int[] nums) {
        List<List<Integer>> res = new ArrayList<>();
        if (nums == null || nums.length < 3) {
            return res;
        }
        Arrays.sort(nums);
        for (int first = 0; first < nums.length - 2; first++) {
            if (nums[first] > 0) {
                return res;
            }
            if (first > 0 && nums[first] == nums[first - 1]) {
                continue;
            }
            int second = first + 1;
            int third = nums.length - 1;
            while (second < third) {
                int curSum = nums[first] + nums[second] + nums[third];
                if (curSum == 0) {
                    res.add(Arrays.asList(nums[first], nums[second], nums[third]));
                    second++;
                    third--;
                    while (second < third && nums[second] == nums[second - 1]) {
                        second++;
                    }
                    while (second < third && nums[third] == nums[third + 1]) {
                        third--;
                    }
                } else if (curSum > 0) {
                    third--;
                } else {
                    second++;
                }
            }
        }
        return res;
    }

    public ListNode reverseList(ListNode head) {
        if (head == null || head.next == null) {
            return head;
        }
        ListNode cur = head;
        ListNode next = head.next;
        ListNode temp = next.next;
        cur.next = null;
        next.next = cur;
        while(temp != null) {
            cur = next;
            next = temp;
            temp = next.next;
            next.next = cur;
        }
        return next;
    }

    public ListNode reverseList2(ListNode head) {
        if (head == null || head.next == null) {
            return head;
        }
        ListNode res = null;
        while(head.next != null) {
            res = head;
            head = head.next;
        }
        process(head);
        head.next = null;
        return res;
    }

    public static ListNode reverseList3(ListNode head) {
        if (head == null || head.next == null) {
            return head;
        }
        // 这个地方的resNode从始至终都没有变过，都是该链表的最后一个节点
        ListNode resNode = reverseList3(head.next);
        // 这也是为什么此处的head.next.next不直接使用resNode的原因
        head.next.next = head;
        head.next = null;
        return resNode;
    }

    public static void main(String[] args){
        ListNode node1 = new ListNode(1);

        ListNode node2 = new ListNode(2);
        node1.next = node2;
        ListNode node3 = new ListNode(3);
        node2.next = node3;
        ListNode node4 = new ListNode(4);
        node3.next = node4;
        ListNode node5 = new ListNode(5);
        node4.next = node5;
        node5.next = null;
        reverseList3(node1);
    }

    public ListNode process(ListNode head) {
        if (head.next == null) {
            return head;
        }
        ListNode listNode = reverseList2(head.next);
        listNode.next = head;
        return head;
    }
    
    public static class ListNode {
        int val;
        ListNode next;

        ListNode(int x) {
            val = x;
        }
    }
}
