package com.leetcode.demo.ycq.linkedList;

import org.junit.Before;
import org.junit.Test;

/*
 * 203. 移除链表元素
 * 给你一个链表的头节点 head 和一个整数 val ，请你删除链表中所有满足 Node.val == val 的节点，并返回 新的头节点
 * 输入：head = [1,2,6,3,4,5,6], val = 6
 * 输出：[1,2,3,4,5]
 * */
public class RemoveElements {

    class ListNode {
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

    // md 自己写的是什么垃圾
    public ListNode removeElements1(ListNode head, int val) {
        if (head == null || (head.next == null && head.val == val)) {
            return null;
        }
        remove(head, val);
        if (head.val == val){
            head = head.next;
        }
        return head;
    }

    // md 自己写的是什么垃圾
    public void remove(ListNode node, int val) {
        if (node == null){
            return;
        }
        if (node.next != null && node.next.val == val){
            node.next = node.next.next;
            remove(node, val);
        }
        remove(node.next, val);
    }

    // 真正的递归
    public ListNode removeElements2(ListNode head, int val) {
        if (head == null){
            return head;
        }
        // 递归遇到return是会一层层返回的!!! (这就相当于从链表的尾部开始遍历)
        head.next = removeElements2(head.next, val);
        return head.val == val ? head.next : head;
    }

    // 真正的迭代
    public ListNode removeElements3(ListNode head, int val) {
        // 创建一个哑节点方便处理头节点
        ListNode dummyHead = new ListNode(0,  head);
        ListNode temp = dummyHead;
        while (temp.next != null){
            if (temp.next.val == val){
                temp.next = temp.next.next;
            } else {
                temp = temp.next;
            }
        }
        return dummyHead.next;
    }

    public void init(ListNode head, int[] nums, int index) {
        if (index == nums.length - 1) {
            head.val = nums[index];
            return;
        }
        if (index == nums.length) {
            return;
        }
        head.val = nums[index];
        head.next = new ListNode();
        init(head.next, nums, ++index);
    }

    @Test
    public void test() {
        int[] nums = {1,2,3,4,5,6,7};
        int val = 7;
        ListNode node = new ListNode();
        init(node, nums, 0);
        after(node);
        ListNode listNode = removeElements3(node, val);
        after(listNode);
    }

    public void after(ListNode node){
        ListNode temp = node;
        System.out.println("---");
        while (temp != null){
            System.out.print(temp.val);
            temp = temp.next;
        }
        System.out.println("---");
    }

}
