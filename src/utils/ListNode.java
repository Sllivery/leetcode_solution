package utils;

import java.util.List;

public class ListNode {
    public int val;
    public ListNode next;

    public ListNode() {

    }

    public ListNode(int[] array) {
        this(array[0]);
        ListNode head = this;
        for (int i = 1; i < array.length; i++) {
            head.next = new ListNode(array[i]);
            head = head.next;
        }
    }

    public ListNode(int x) {
        val = x;
        next = null;
    }

    @Override
    public String toString() {
        StringBuilder builder = new StringBuilder();
        builder.append(this.val + "-> ");
        ListNode next = this.next;
        while (next != null) {
            builder.append(next.val + "-> ");
            next = next.next;
        }
        return builder.toString();
    }
}
