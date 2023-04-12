package microsoft_q.linked_list;

import utils.ListNode;

import java.util.HashSet;

public class LinkedListCycle {
    public static void main(String[] args) {

    }

    static class Solution {
        public boolean hasCycle(ListNode head) {
            if (head == null) {
                return false;
            }
            HashSet<ListNode> map = new HashSet<>();
            while (head.next != null) {
                if (!map.contains(head)) {
                    map.add(head);
                    head = head.next;
                } else {
                    return true;
                }
            }
            return false;
        }
    }
}
