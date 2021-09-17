package com.leetcode.demo.ycq.linkedList;

/*
*707. 设计链表
*设计链表的实现。您可以选择使用单链表或双链表。单链表中的节点应该具有两个属性：val 和 next。val 是当前节点的值，next 是指向下一个节点的指针/引用。如果要使用双向链表，则还需要一个属性 prev 以指示链表中的上一个节点。假设链表中的所有节点都是 0-index 的。

在链表类中实现这些功能：

get(index)：获取链表中第 index 个节点的值。如果索引无效，则返回-1。
addAtHead(val)：在链表的第一个元素之前添加一个值为 val 的节点。插入后，新节点将成为链表的第一个节点。
addAtTail(val)：将值为 val 的节点追加到链表的最后一个元素。
addAtIndex(index,val)：在链表中的第 index 个节点之前添加值为 val  的节点。如果 index 等于链表的长度，则该节点将附加到链表的末尾。如果 index 大于链表长度，则不会插入节点。如果index小于0，则在头部插入节点。
deleteAtIndex(index)：如果索引 index 有效，则删除链表中的第 index 个节点。
*
* */
public class MyLinkedList {

    private int val;

    private MyLinkedList next;

    private int length;

    public MyLinkedList(){
    }


    public MyLinkedList(int val, MyLinkedList node){
        this.val = val;
        this.next = node;
        length++;
    }

    public int get(int index) {
        if (index < 0) {
            return -1;
        }
        if (this.next == null){
            return -1;
        }
        MyLinkedList temp = this.next;
        while (index != 0) {
            if (temp.next == null){
                return -1;
            }
            temp = temp.next;
            index--;
        }
        return temp.val;
    }

    public void addAtHead(int val) {
        if (this.next != null) {
            this.next = new MyLinkedList(val, this.next);
        } else {
            this.next = new MyLinkedList(val, null);
        }
        length++;
    }

    public void addAtTail(int val) {
        MyLinkedList temp = this;
        while (temp.next != null){
            temp = temp.next;
        }

        temp.next = new MyLinkedList(val, null);
        length++;
    }

    public void addAtIndex(int index, int val) {
        if (index <= 0){
            addAtHead(val);
        } else if (index == length){
            addAtTail(val);
        } else if (index < length){
            MyLinkedList temp = this;
            while (index != 0){
                temp = temp.next;
                index--;
            }
            temp.next = new MyLinkedList(val, temp.next);
            length++;
        }
    }

    public void deleteAtIndex(int index) {
        if (index >= 0 && index < length){
            MyLinkedList temp = this;
            while (index != 0){
                temp = temp.next;
                index--;
            }
            if (temp.next.next == null){
                temp.next = null;
            } else {
                temp.next = temp.next.next;
            }
            length--;
        }
    }

    public static void main(String[] args) {
        MyLinkedList myLinkedList = new MyLinkedList();
        myLinkedList.addAtHead(9);
        myLinkedList.get(1);
        myLinkedList.addAtIndex(1, 1);
        myLinkedList.addAtIndex(1, 7);
        myLinkedList.deleteAtIndex(1);
        myLinkedList.addAtHead(7);
        myLinkedList.addAtHead(4);
        myLinkedList.deleteAtIndex(1);
        myLinkedList.addAtIndex(1, 4);
        myLinkedList.addAtHead(2);
        myLinkedList.deleteAtIndex(5);
        System.out.println();
    }

}
