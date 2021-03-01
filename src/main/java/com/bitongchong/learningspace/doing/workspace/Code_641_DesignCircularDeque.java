package com.bitongchong.learningspace.doing.workspace;

/**
 * @author liuyuehe
 * @date 2021/1/23 16:57
 */
public class Code_641_DesignCircularDeque {
    static class Node {
        private int value;
        private Node pre;
        private Node next;

        public Node(int value) {
            this.value = value;
        }
    }
    private Node head;
    private Node tail;
    private int maxSize;
    private int curSize;

    /** Initialize your data structure here. Set the size of the deque to be k. */
    public Code_641_DesignCircularDeque(int k) {
        maxSize = k;
        head = new Node(-1);
        tail = new Node(-1);
        head.next = tail;
        tail.pre = head;
    }

    /** Adds an item at the front of Deque. Return true if the operation is successful. */
    public boolean insertFront(int value) {
        if (curSize + 1 > maxSize) {
            return false;
        }
        Node next = head.next;
        Node insert = new Node(value);
        head.next = insert;
        insert.pre = head;
        insert.next = next;
        next.pre = insert;
        curSize++;
        return true;
    }

    /** Adds an item at the rear of Deque. Return true if the operation is successful. */
    public boolean insertLast(int value) {
        if (curSize + 1 > maxSize) {
            return false;
        }
        Node pre = tail.pre;
        Node insert = new Node(value);
        tail.pre = insert;
        insert.next = tail;
        insert.pre = pre;
        pre.next = insert;
        curSize++;
        return true;
    }

    /** Deletes an item from the front of Deque. Return true if the operation is successful. */
    public boolean deleteFront() {
        if (curSize <= 0) {
            return false;
        }
        Node next = head.next.next;
        head.next = next;
        next.pre = head;
        curSize--;
        return true;
    }

    /** Deletes an item from the rear of Deque. Return true if the operation is successful. */
    public boolean deleteLast() {
        if (curSize <= 0) {
            return false;
        }
        Node pre = tail.pre.pre;
        tail.pre = pre;
        pre.next = tail;
        curSize--;
        return true;
    }

    /** Get the front item from the deque. */
    public int getFront() {
        return head.next.value;
    }

    /** Get the last item from the deque. */
    public int getRear() {
        return tail.pre.value;
    }

    /** Checks whether the circular deque is empty or not. */
    public boolean isEmpty() {
        return curSize == 0;
    }

    /** Checks whether the circular deque is full or not. */
    public boolean isFull() {
        return curSize == maxSize;
    }
}
