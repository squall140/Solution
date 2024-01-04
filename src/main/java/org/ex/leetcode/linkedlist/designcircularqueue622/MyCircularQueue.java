package org.ex.leetcode.linkedlist.designcircularqueue622;

/**
 * @desc:
 * @author: Leif
 * @date: 2024/1/4 15:02
 */
public class MyCircularQueue {
    private ListNode head;
    private ListNode tail;
    private int capacity;
    private int size;

    public MyCircularQueue(int k){
        capacity = k;
        size = 0;
    }
    public boolean enQueue(int value) {
        if(isFull()) return false;

        ListNode node = new ListNode(value);
        if (head == null){
            head = tail = node;
        }else{
            tail.next = node;
            tail = node;
        }
        size++;
        return true;
    }

    public boolean deQueue() {
        if(isEmpty()) return false;

        ListNode node = head;
        head = head.next;
        size--;
        return true;
    }

    public int Front() {
        if (isEmpty()) return -1;
        return head.val;
    }

    public int Rear() {
        if(isEmpty()) return -1;
        return tail.val;
    }

    public boolean isEmpty() {
        return size == 0;
    }

    public boolean isFull() {
        return size == capacity;
    }


}
