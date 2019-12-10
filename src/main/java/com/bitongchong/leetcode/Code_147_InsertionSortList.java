package com.bitongchong.leetcode;

public class Code_147_InsertionSortList {

    public ListNode insertionSortList(ListNode head) {
        if (head == null || head.next == null) return head;
        ListNode cur = head;
        ListNode res = new ListNode(Integer.MIN_VALUE);
        ListNode next;
        ListNode curRes;
        while (cur != null) {
            next = cur.next;
            curRes = res;
            while (curRes.next != null && cur.val >= curRes.next.val) {
                curRes = curRes.next;
            }
            cur.next = curRes.next;
            curRes.next = cur;
            cur = next;
        }
        return res.next;
    }

    public class ListNode {
        int val;
        ListNode next;

        ListNode(int x) {
            val = x;
            next = null;
        }
    }
}
