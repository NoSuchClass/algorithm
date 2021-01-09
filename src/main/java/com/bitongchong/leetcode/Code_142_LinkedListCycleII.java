package com.bitongchong.leetcode;

import com.bitongchong.util.ListNode;

/**
 * @author liuyuehe
 * @date 2020/12/22 23:54
 */
public class Code_142_LinkedListCycleII {
    public ListNode detectCycle(ListNode head) {
        if (head == null || head.next == null) {
            return null;
        }
        ListNode fast = head;
        ListNode slow = head;
        while(fast != null && fast.next != null) {
            fast = fast.next.next;
            slow = slow.next;
            if (fast == slow) {
                ListNode start = head;
                while (start != slow) {
                    slow = slow.next;
                    start = start.next;
                }
                return start;
            }
        }
        return null;
    }
}
