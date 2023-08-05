package com.pivovarit.leet;

import java.util.Collections;
import java.util.Objects;
import java.util.stream.Collectors;

class AddTwoNumbers {

    /**
     * You are given two non-empty linked lists representing two non-negative integers. The digits are stored in reverse order, and each of their nodes contains a single digit. Add the two numbers and return the sum as a linked list.
     * You may assume the two numbers do not contain any leading zero, except the number 0 itself.
     */
    public static ListNode<Integer> addTwoNumbers(ListNode<Integer> i1, ListNode<Integer> i2) {
        Objects.requireNonNull(i1);
        Objects.requireNonNull(i2);

        var node1 = i1;
        var node2 = i2;

        var valueFirst = i1.getValue();
        var valueSecond = i2.getValue();

        int sum = valueFirst + valueSecond;
        int value = sum % 10;
        int carry = sum / 10;

        var result = new ListNode<>(value);
        var current = result;

        while (node1.getNext() != null || node2.getNext() != null) {
            var next1 = node1.getNext();
            var next2 = node2.getNext();

            valueFirst = (next1 != null) ? next1.getValue() : 0;
            valueSecond = (next2 != null) ? next2.getValue() : 0;

            sum = valueFirst + valueSecond + carry;
            value = sum % 10;
            carry = sum / 10;

            current.setNext(new ListNode<>(value));
            current = current.getNext();

            if (next1 != null) {
                node1 = next1;
            }
            if (next2 != null) {
                node2 = next2;
            }
        }

        if (carry > 0) {
            current.setNext(new ListNode<>(carry));
        }

        return result;
    }

    public static ListNode<Integer> from(String value) {
        Objects.requireNonNull(value);
        if (value.isBlank()) {
            throw new IllegalArgumentException();
        }
        var list = value.chars()
          .mapToObj(i -> Integer.valueOf(String.valueOf((char) i)))
          .map(ListNode::new)
          .collect(Collectors.toList());

        Collections.reverse(list);

        var last = list.get(0);

        for (int i = 1; i < list.size(); i++) {
            var next = list.get(i);
            last.setNext(next);
            last = next;
        }

        return list.get(0);
    }

    static class ListNode<T> {
        private final T value;
        private ListNode<T> next;

        ListNode(T val) {
            this.value = val;
        }

        T getValue() {
            return value;
        }

        ListNode<T> getNext() {
            return next;
        }

        void setNext(ListNode<T> next) {
            this.next = next;
        }

        @Override
        public String toString() {
            return value + (next != null ? next.toString() : "");
        }
    }
}
