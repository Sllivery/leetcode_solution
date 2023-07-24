package daily_problems;

import utils.ListNode;

public class PartitionList89 {
    public static void main(String[] args) {
        int[] array = {1, 4, 3, 2, 5, 2};
        ListNode test = new ListNode(array);
        Solution solution = new Solution();
        ListNode result = solution.partition(test, 3);
        System.out.println(result);
    }

    static class Solution {
        public ListNode partition(ListNode head, int x) {
            ListNode lesser = new ListNode(0);
            ListNode greater = new ListNode(0);
            ListNode pointer = head;
            ListNode pointerOfLesser = lesser;
            ListNode pointerOfGreater = greater;
            while (pointer != null) {
                if (pointer.val >= x) {
                    pointerOfGreater.next = new ListNode(pointer.val);
                    pointerOfGreater = pointerOfGreater.next;
                } else if (pointer.val < x) {
                    pointerOfLesser.next = new ListNode(pointer.val);
                    pointerOfLesser = pointerOfLesser.next;
                }
                pointer = pointer.next;
            }
            pointerOfLesser.next = greater.next;
            return lesser.next;
        }
    }
}
