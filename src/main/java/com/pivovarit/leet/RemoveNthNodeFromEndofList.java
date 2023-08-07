package com.pivovarit.leet;

class RemoveNthNodeFromEndofList {

    /**
     * Given the head of a linked list, remove the nth node from the end of the list and return its head.
     */
    static ListNode<Integer> removeNthFromEnd(ListNode<Integer> head, int n) {
        if (n < 1) {
            throw new IllegalArgumentException("n can't be lower than 1");
        }
        var startingNode = new ListNode<>(-1);
        startingNode.next = head;

        var first = startingNode;
        var second = startingNode;

        for (int i = 0; i <= n; i++) {
            first = first.next;
            if (first == null) {
                return head;
            }
        }

        while (first != null) {
            first = first.next;
            second = second.next;
        }

        second.next = second.next.next;
        return startingNode.next;
    }

    private static class ListNode<T> {
        final T val;
        ListNode<T> next;

        ListNode(T val) {
            this.val = val;
        }

        ListNode(T val, ListNode<T> next) {
            this.val = val;
            this.next = next;
        }

        @Override
        public String toString() {
            return val.toString() + (next != null ? next : "");
        }
    }
}
