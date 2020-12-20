package com.bitongchong.learningspace.doing;

import com.bitongchong.util.ListNode;

/**
 * @author liuyuehe
 * @date 2020/12/20 11:25
 */
public class Code_024_SwapNodesInPairs {
    public ListNode swapPairs(ListNode head) {
        if (head == null || head.next == null) {
            return head;
        }
        ListNode res = head.next;
        ListNode preNode = null;
        while(head != null && head.next != null) {
            ListNode curNode = head;
            ListNode nextNode = head.next;
            if (preNode != null) {
                preNode.next = nextNode;
            }
            curNode.next = nextNode.next;
            nextNode.next = curNode;
            preNode = curNode;
            head = head.next;
        }
        return res;
    }
    
    public static void main(String[] args){
        new Code_024_SwapNodesInPairs().swapPairs(ListNode.getHeadNode());
    }
}
