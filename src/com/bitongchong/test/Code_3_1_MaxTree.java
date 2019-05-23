package com.bitongchong.test;

import java.util.HashMap;
import java.util.Stack;

/**
 * 题目描述：
 * 定义二叉树结构如下，同时，一个数组的MaxTree定义如下：
 * 传入的数值中没有重复值，MaxTree是一棵二叉树，数组的每一个值对应一个二叉树结点。
 * 包括 MaxTree树在内且在其中的每一棵子树上,值最大的节点都是树的头
 * 给定一个没有重复元素的数组arr,写出生成这个数组的 MaxTree的函数,
 * 要求如果数组长度为N,则时间复杂度为 0(N)、额外空间复杂度为0(N)。
 */

/**
 * 导入：单调栈
 * 使用场景：给一个数组，求每一个数离它最近的那个较大的数（左边右边都要求）
 * 原理：使用一个栈，这个栈的结构是从栈底到栈顶由大到小的结构，如果满足这个结构，那么添加数值进入
 * 栈中，如果不满住，那么将会由栈中pop出一个值，这个值最左边满足条件的值一定是栈中下一个数（如果
 * 栈里面还有的话，没有就是null），最右边满足条件的值一定是想要添加进栈中的那个数
 */
public class Code_3_1_MaxTree {
    // 题和思想本身不难，难就难在如何通过单调栈的结果来构建出二叉树
    public static Node getMaxTree(int[] arr) {
        Node[] nodeArr = new Node[arr.length];
        for (int i = 0; i < arr.length; i++) {
            nodeArr[i] = new Node(arr[i]);
        }
        Stack<Node> stack = new Stack<Node>();
        HashMap<Node, Node> lBigMap = new HashMap<>();
        HashMap<Node, Node> rBigMap = new HashMap<>();
        // 这儿的处理很精妙，因为涉及到一个点有左右两种情况需要存储，直接存储两种情况不好处理，
        // 因此这儿通过两次循环，分别存储左边和右边最近且较大的值，需要判断某一个数值的情况时，
        // 直接通过对这两个map进行取值判断（需要注意的是，从尾到头进行单调栈的处理时，相当于
        // 将某个数值的左右情况给交换，因此能够实现分别存左右的情况）
        for (int i = 0; i < nodeArr.length; i++) {
            Node curNode = nodeArr[i];
            while (!(stack.isEmpty()) && stack.peek().value < curNode.value) {
                popStackSetMap(stack, lBigMap);
            }
            stack.push(curNode);
        }
        // 如果没有值需要添加时，可能在栈中还存有值，这时候继续按照popStackSetMap的逻辑进行处
        // 理是行得通的（如果stack中还有数，那么离当前数值最近且较大的数一定是stack.peek()得
        // 到的这个数）
        while (!stack.isEmpty()) {
            popStackSetMap(stack, lBigMap);
        }

        for (int i = 0; i < nodeArr.length; i++) {
            Node curNode = nodeArr[i];
            while ((!stack.isEmpty()) && stack.peek().value < curNode.value) {
                popStackSetMap(stack, rBigMap);
            }
            stack.push(curNode);
        }
        while (!stack.isEmpty()) {
            popStackSetMap(stack, rBigMap);
        }

        Node head = null;
        for (int i = 0; i < nodeArr.length; i++) {
            Node curNode = nodeArr[i];
            Node left = lBigMap.get(curNode);
            Node right = rBigMap.get(curNode);
            if (left == null && right == null) {
                head = curNode;
            } else if (left == null) {
                if (right.left == null) {
                    right.left = curNode;
                } else {
                    right.right = curNode;
                }
            } else if (right == null) {
                if (left.left == null) {
                    left.left = curNode;
                } else {
                    left.right = curNode;
                }
            } else {
                Node parent = left.value < right.value ? left : right;
                if (parent.left == null) {
                    parent.left = curNode;
                } else {
                    parent.right = curNode;
                }
            }
        }
        return head;
    }

    public static void popStackSetMap(Stack<Node> stack, HashMap<Node, Node> map) {
        Node popNode = stack.pop();
        if (stack.isEmpty()) {
            map.put(popNode, null);
        } else {
            map.put(popNode, stack.peek());
        }
    }

    public static void main(String[] args) {
        int[] arr = {1, 7, 9, 2, 6, 0};
        System.out.println(getMaxTree(arr));
    }

    // 这儿可以直接通过一个大根堆来做，但是为了熟悉单调栈，这儿直接使用单调栈的思想来做
    public static class Node {
        public int value;
        public Node left;
        public Node right;

        public Node(int data) {
            this.value = data;
        }
    }
}
