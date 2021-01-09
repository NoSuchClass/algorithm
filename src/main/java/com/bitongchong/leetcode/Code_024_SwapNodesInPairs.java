package com.bitongchong.leetcode;

import com.bitongchong.util.ListNode;

/**
 * @author liuyuehe
 * @date 2020/12/20 11:25
 */
public class Code_024_SwapNodesInPairs {
    // 迭代解法，时间复杂度O(N)，空间复杂度O(1)
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
    // 递归解法，时间复杂度O(N)，空间复杂度：O(N)，其中 nn 是链表的节点数量。空间复杂度主要取决于递归调用的栈空间。
    public ListNode swapPairsRecursive(ListNode head) {
        if (head == null || head.next == null) {
            return head;
        }
        ListNode resNode = head.next;
        head.next = swapPairsRecursive(head.next.next);
        resNode.next = head;
        return resNode;
    }
    
    public static void main(String[] args){
        new Code_024_SwapNodesInPairs().swapPairs(ListNode.getHeadNode());
    }
}
