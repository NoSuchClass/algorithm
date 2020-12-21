package com.bitongchong.leetcode;

import com.bitongchong.util.ListNode;

/**
 * @author liuyuehe
 * @date 2020/12/21 23:11
 */
public class Code_206_ReverseLinkedList {

    public ListNode reverseListByIterator(ListNode head) {
        // 迭代解法，一步一步进行，一次变更一条指针
        ListNode pre = null;
        ListNode cur = head;
        while(cur != null) {
            ListNode next = cur.next;
            cur.next = pre;
            pre = cur;
            cur = next;
        }
        return pre;
    }

    public ListNode reverseListByRecursive(ListNode head) {
        // 递归解法
        if(head.next == null) {
            return head;
        }
        // 此处唯一的作用就是传递一个结果，最后进行指针操作的实际上还是head
        ListNode resNode = reverseListByRecursive(head.next);
        head.next.next = head;
        head.next = null;
        return resNode;
    }
}
