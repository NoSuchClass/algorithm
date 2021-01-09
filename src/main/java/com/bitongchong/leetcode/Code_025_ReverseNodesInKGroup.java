package com.bitongchong.leetcode;

import com.bitongchong.util.ListNode;

/**
 * @author liuyuehe
 * @date 2020/12/21 22:21
 */
public class Code_025_ReverseNodesInKGroup {
    public ListNode reverseKGroup(ListNode head, int k) {
        // 1、如何以K为单位进行链表的反转
        // 2、每K个循环的头节点是如何传递形成最后的链表的
        ListNode res = new ListNode();
        ListNode pre = res;
        pre.next = head;
        while(head != null) {
            ListNode tail = pre;
            for (int i = 0; i < k; i++) {
                tail = tail.next;
                if (tail == null) {
                    return res.next;
                }
            }
            ListNode next = tail.next;
            tail.next = null;
            ListNode[] listNodes = reverseNode(head, tail);
            ListNode start = listNodes[0];
            ListNode end = listNodes[1];
            pre.next = start;
            end.next = next;
            pre = end;
            head = next;
        }
        return res.next;
    }

    public ListNode[] reverseNode(ListNode head, ListNode tail) {
        ListNode pre = null;
        ListNode cur = head;
        while(pre != tail) {
            ListNode next = cur.next;
            cur.next = pre;
            pre = cur;
            cur = next;
        }
        return new ListNode[]{head, pre};
    }
    
    public static void main(String[] args){
        new Code_025_ReverseNodesInKGroup().reverseKGroup(ListNode.getHeadNode(), 2);
    }
}
