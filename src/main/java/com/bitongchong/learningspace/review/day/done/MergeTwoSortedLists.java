package com.bitongchong.learningspace.review.day.done;

import com.bitongchong.util.ListNode;

/**
 * @author liuyuehe
 * @date 2021/1/9 9:24
 */
public class MergeTwoSortedLists {
    public ListNode mergeTwoLists(ListNode l1, ListNode l2) {
        ListNode head = new ListNode(0);
        ListNode res = head;
        while(l1 != null && l2 != null) {
            if (l1.val > l2.val) {
                head.next = l2;
                l2 = l2.next;
            } else {
                head.next = l1;
                l1 = l1.next;
            }
            head = head.next;
        }
        head.next = l1 == null ? l2 : l1;
        return res.next;
    }

    public ListNode merge(ListNode l1, ListNode l2) {
        if (l1 == null) {
            return l2;
        } else if (l2 == null) {
            return l1;
        } else if (l1.val > l2.val) {
            l2.next = merge(l1, l2.next);
            return l2;
        } else {
            l1.next = merge(l1.next, l2);
            return l1;
        }
    }
}
