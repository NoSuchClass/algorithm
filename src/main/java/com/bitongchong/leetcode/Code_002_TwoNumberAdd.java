package com.bitongchong.leetcode;

/**
 * @author liuyuehe
 * @description 两数之和
 * @date 2019/7/30
 */
public class Code_002_TwoNumberAdd {
    public static class ListNode {
        int val;
        ListNode next;

        ListNode(int x) {
            val = x;
        }
    }

    public ListNode addTwoNumbers(ListNode l1, ListNode l2) {
        int overNum = 0;
        ListNode node = new ListNode(0);
        ListNode resNode = node;
        while (l1 != null && l2 != null) {
            int resNum = l1.val + l2.val + overNum;
            overNum = resNum >= 10 ? 1 : 0;
            resNode.next = new ListNode(resNum % 10);
            resNode = resNode.next;
            l1 = l1.next;
            l2 = l2.next;
        }
        ListNode listNode = l1 != null ? l1 : l2;
        while (listNode != null) {
            int resNum = listNode.val + overNum;
            overNum = resNum >= 10 ? 1 : 0;
            resNode.next = new ListNode(resNum % 10);
            resNode = resNode.next;
            listNode = listNode.next;
        }
        if (overNum != 0) {
            resNode.next = new ListNode(1);
        }
        return node.next;
    }

    public static void main(String[] args) {
        ListNode node = new ListNode(3);
        ListNode node2 = new ListNode(9);
        node2.next = new ListNode(9);
        new Code_002_TwoNumberAdd().addTwoNumbers(node, node2);
    }
}
