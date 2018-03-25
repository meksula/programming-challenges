package com.meksula.collections;

/**
 * @Author
 * Karol Meksuła
 * 25-03-2018
 * */

public class IntegerLinkedList implements List<Integer>{

    private ListNode head;
    private int size = 0;

    @Override
    public void putElement(Integer object) {
        if (head == null) {
            head = new ListNode(object);
            size++;
            return;
        }
        putNext(object);
        size++;
    }

    private void putNext(Integer object) {
        ListNode current = head;

        while (current.next != null)
            current = current.next;

        current.next = new ListNode(object);
    }

    @Override
    public Integer getElement(int number) {
        return null;
    }

    @Override
    public int size() {
        return size;
    }

    @Override
    public void print() {
        int count = 0;
        ListNode current = head;
        while (current != null) {
            System.out.println("Value [" + count + "]: " + current.value);
            current = current.next;
            count++;
        }
    }

    private static class ListNode {
        private int value;
        private ListNode next;

        ListNode(Integer object) {
            value = object;
            next = null;
        }
    }
}