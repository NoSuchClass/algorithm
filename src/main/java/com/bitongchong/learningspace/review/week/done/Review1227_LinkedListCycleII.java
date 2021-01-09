package com.bitongchong.learningspace.review.week.done;

import com.bitongchong.util.ListNode;

/**
 * @author liuyuehe
 * @date 2020/12/22 23:54
 */
public class Review1227_LinkedListCycleII {
    public ListNode detectCycle(ListNode head) {
        if (head == null || head.next == null) {
            return null;
        }
        ListNode slow = head.next;
        ListNode fast = head.next.next;
        while(slow != fast) {
            if (fast == null || fast.next == null) {
                return null;
            }
            slow = slow.next;
            fast = fast.next.next;
        }
        ListNode temp = head;
        while(temp != slow) {
            slow = slow.next;
            temp = temp.next;
        }
        return temp;
    }
}
