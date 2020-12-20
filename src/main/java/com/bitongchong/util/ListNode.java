package com.bitongchong.util;

import com.bitongchong.leetcode.Code_015_ThreeSum;

/**
 * @author liuyuehe
 * @date 2020/12/20 11:26
 */
public class ListNode {
    public int val;
    public ListNode next;

    ListNode() {
    }

    ListNode(int val) {
        this.val = val;
    }

    ListNode(int val, ListNode next) {
        this.val = val;
        this.next = next;
    }

    public static ListNode getHeadNode() {
        ListNode node1 = new ListNode(1);
        ListNode node2 = new ListNode(2);
        node1.next = node2;
        ListNode node3 = new ListNode(3);
        node2.next = node3;
        ListNode node4 = new ListNode(4);
//        ListNode node5 = new ListNode(5);
//        node4.next = node5;
        node3.next = node4;
        node4.next = null;
        return node1;
    }
}
