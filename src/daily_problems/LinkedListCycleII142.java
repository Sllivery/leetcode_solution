package daily_problems;

import utils.ListNode;

import java.util.HashMap;

public class LinkedListCycleII142 {
    public static void main(String[] args) {
        int[] array = {3, 2, 0, -4};
    }

    static public class Solution {
        public ListNode detectCycle(ListNode head) {
            HashMap<ListNode, ListNode> map = new HashMap<>();
            while (head != null) {
                if (map.containsKey(head)) {
                    return map.get(head);
                }
                map.put(head, head);
                head = head.next;
            }
            return null;
        }
    }
}
