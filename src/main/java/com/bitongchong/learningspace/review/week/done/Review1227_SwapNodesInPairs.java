package com.bitongchong.learningspace.review.week.done;

import com.bitongchong.util.ListNode;

/**
 * @author liuyuehe
 * @date 2020/12/21 22:06
 */
public class Review1227_SwapNodesInPairs {
    public ListNode swapPairs(ListNode head) {
        if (head == null || head.next == null) {
            return head;
        }
        ListNode cur = head;
        ListNode pre = new ListNode();
        while(cur != null && cur.next != null) {
            ListNode next = cur.next;
            ListNode temp = cur.next.next;
            pre.next = next;
            next.next = cur;
            pre = cur;
            cur.next = temp;
            cur = temp;
        }
        return pre.next;
    }

    public ListNode swapPairs2(ListNode head) {
        if (head == null || head.next == null) {
            return head;
        }
        ListNode res = head.next;
        head.next = swapPairs2(head.next.next);
        res.next = head;
        return res;
    }
}
