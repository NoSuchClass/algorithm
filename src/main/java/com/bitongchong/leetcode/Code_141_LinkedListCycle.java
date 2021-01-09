package com.bitongchong.leetcode;

import com.bitongchong.util.ListNode;

/**
 * @author liuyuehe
 * @date 2020/12/22 9:21
 */
public class Code_141_LinkedListCycle {
    public boolean hasCycle(ListNode head) {
        if (head == null || head.next == null) {
            return false;
        }
        ListNode fastNode = head;
        ListNode slowNode = head;
        while(fastNode != null && fastNode.next != null) {
            fastNode = fastNode.next.next;
            slowNode = slowNode.next;
            if (fastNode == slowNode) {
                return true;
            }
        }
        return false;
    }
}
