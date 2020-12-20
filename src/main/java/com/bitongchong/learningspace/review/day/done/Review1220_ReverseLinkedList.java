package com.bitongchong.learningspace.review.day.done;

/**
 * @author liuyuehe
 * @date 2020/12/20 10:44
 */
public class Review1220_ReverseLinkedList {
    public ListNode reverseList(ListNode head) {
        if (head == null || head.next == null) {
            return head;
        }
        ListNode resNode = reverseList(head.next);
        head.next.next = head;
        head.next = null;
        return resNode;
    }

    public class ListNode {
        int val;
        ListNode next;

        ListNode(int x) {
            val = x;
        }
    }
}
