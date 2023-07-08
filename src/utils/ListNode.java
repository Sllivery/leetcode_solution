package utils;

import java.util.List;

public class ListNode {
    public int val;
    public ListNode next;

    public ListNode() {

    }

    public ListNode(int[] array) {
        this.val = array[0];
        for (int i = 1; i < array.length; i++) {
            this.next = new ListNode(array[i]);

        }
    }

    public ListNode(int x) {
        val = x;
        next = null;
    }

    @Override
    public String toString() {
        return super.toString();
    }
}
