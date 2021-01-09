package com.bitongchong.learningspace.review.day.todo;

import com.bitongchong.util.ListNode;

/**
 * @author liuyuehe
 * @date 2020/12/30 23:15
 */
public class Code_021_MergeTwoSortedLists {
    public ListNode mergeTwoLists(ListNode l1, ListNode l2) {
        ListNode preHead = new ListNode();
        ListNode pre = preHead;
        while(l1 != null && l2 != null) {
            if (l1.val >= l2.val) {
                pre.next = l2;
                l2 = l2.next;
            } else {
                pre.next = l1;
                l1 = l1.next;
            }
            pre = pre.next;
        }
        pre.next = l1 == null ? l2 : l1;
        return preHead.next;
    }

    public ListNode mergeTwoListsByRecursive(ListNode l1, ListNode l2) {
        if (l1 == null) {
            return l2;
        } else if (l2 == null) {
            return l1;
        } else if (l1.val >= l2.val) {
            l2.next = mergeTwoListsByRecursive(l1, l2.next);
            return l2;
        } else {
            l1.next = mergeTwoListsByRecursive(l1.next, l2);
            return l1;
        }
    }
}
