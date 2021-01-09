package com.bitongchong.learningspace.review.week.done;

import com.bitongchong.util.ListNode;

/**
 * @author liuyuehe
 * @date 2020/12/22 0:04
 */
public class Review1227_ReverseNodesInKGroup {
    public ListNode reverseKGroup(ListNode head, int k) {
        if (head.next == null || k == 1) {
            return head;
        }
        ListNode res = new ListNode();
        res.next = head;
        ListNode pre = res;
        int curNodeCount = 1;
        while(head != null) {
            if (curNodeCount % k == 0) {
                ListNode next = head.next;
                head.next = null;
                ListNode[] listNodes = reverseList(pre.next);
                pre.next = listNodes[0];
                listNodes[1].next = next;
                pre = listNodes[1];
                head = next;
            } else {
                head = head.next;
            }
            curNodeCount++;
        }
        return  res.next;
    }

    public ListNode[] reverseList(ListNode head) {
        ListNode pre = null;
        ListNode cur = head;
        while(cur != null) {
            ListNode next = cur.next;
            cur.next = pre;
            pre = cur;
            cur = next;
        }
        return new ListNode[]{pre, head};
    }
}
