package com.leetcode.demo.lpc.链表;

import org.junit.Test;

/**
 * <p>
 * 给你一个链表的头节点 head 和一个整数 val ，请你删除链表中所有满足 Node.val == val 的节点，并返回 新的头节点 。
 * <p/>
 * 输入：head = [1,2,6,3,4,5,6], val = 6
 * 输出：[1,2,3,4,5]
 *
 * @author Ray
 * date: 2021.09.13 22:04
 */
public class Q203移除链表元素 {

    @Test
    public void 自己() {
        ListNode listNode = new ListNode(1, new ListNode(2, new ListNode(6, new ListNode(3, new ListNode(4, new ListNode(5, new ListNode(6)))))));
//        ListNode listNode = new ListNode(7, new ListNode(7, new ListNode(7, new ListNode(7))));
        ListNode listNode1 = removeElements(listNode, 6);
        System.out.println();
    }

    public ListNode removeElements(ListNode head, int val) {
        // 自己本身不是null 而且自己的值是val 应该直接跳过到下一个
        if (head != null && head.val == val) {
            head = removeElements(head.next, val);
        } else if (head != null && head.next != null) {
            // 当自己本身不为null 且它的next也不为null 保留自己
            head.next = removeElements(head.next, val);
        }
        return head;
    }

    public class ListNode {
        int val;
        ListNode next;

        ListNode() {
        }

        ListNode(int val) {
            this.val = val;
        }

        ListNode(int val, ListNode next) {
            this.val = val;
            this.next = next;
        }
    }
}
