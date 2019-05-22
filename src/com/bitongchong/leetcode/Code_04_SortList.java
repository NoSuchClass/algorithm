package com.bitongchong.leetcode;

public class Code_04_SortList {
    public static void main(String[] args) {
        ListNode node = new ListNode(3);
        node.next = new ListNode(9);
        node.next.next = new ListNode(1);
        ListNode node1 = new Code_04_SortList().sortList(node);
        while (node1 != null) {
            System.out.println(node1.val);
            node1 = node1.next;
        }
    }

    public ListNode sortList(ListNode head) {
        if (head == null || head.next == null) return head;
        ListNode minNode = getMinNode(head);
        ListNode minNodeNext = minNode.next;
        minNode.next = null; // 分割链表
        return merge(sortList(head), sortList(minNodeNext));
    }

    private ListNode getMinNode(ListNode node) {
        ListNode slow = node;
        ListNode fast = node;
        while (fast.next != null && fast.next.next != null) {
            slow = slow.next;
            fast = fast.next.next;
        }
        return slow;
    }

    private ListNode merge(ListNode head1, ListNode head2) {
        ListNode resNode = new ListNode(0);
        ListNode node = resNode;
        ListNode node1 = head1;
        ListNode node2 = head2;
        while (node1 != null && node2 != null) {
            if (node1.val > node2.val) {
                node.next = node2;
                node2 = node2.next;
            } else {
                node.next = node1;
                node1 = node1.next;
            }
            node = node.next;
        }
        node.next = node1 == null ? node2 : node1;
        return resNode.next;
    }

    static class ListNode {
        int val;
        ListNode next;

        ListNode(int x) {
            val = x;
            next = null;
        }
    }
}
