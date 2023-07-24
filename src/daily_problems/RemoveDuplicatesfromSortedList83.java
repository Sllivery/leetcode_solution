package daily_problems;

import utils.ListNode;

public class RemoveDuplicatesfromSortedList83 {
    public static void main(String[] args) {
        int[] array = {1};
        ListNode listNode = new ListNode(array);
        Solution solution = new Solution();
        ListNode result = solution.deleteDuplicates(listNode);
        System.out.println(result.toString());
    }

    static class Solution {
        public ListNode deleteDuplicates(ListNode head) {
            if (head == null) return head;
            ListNode pointer = head;
            while (pointer.next != null) {
                if (pointer.val == pointer.next.val){
                    pointer.next = pointer.next.next;
                } else {
                    pointer = pointer.next;
                }
            }
            return head;
        }
    }
}
