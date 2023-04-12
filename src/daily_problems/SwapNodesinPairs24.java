package daily_problems;

import utils.ListNode;

import java.util.List;

public class SwapNodesinPairs24 {
    public static void main(String[] args) {
        ListNode l1 = new ListNode(1);
        ListNode l2 = new ListNode(2);
        ListNode l3 = new ListNode(3);
        ListNode l4 = new ListNode(4);
        ListNode l5 = new ListNode(5);
        ListNode l6 = new ListNode(6);
        l1.next = l2;
        l2.next = l3;

        l3.next = l4;
        l4.next = l5;
        l5.next = l6;

        ListNode head = l1;
        while (head != null) {
            System.out.print(head.val + "->");
            head = head.next;
        }
        System.out.println();
        head = l1;
        Solution solution = new Solution();
        ListNode result = solution.swapPairs(head);
        while (result != null) {
            System.out.print(result.val + "->");
            result = result.next;
        }
    }

    static class Solution {
        public ListNode swapPairs(ListNode head) {
            ListNode dummy = new ListNode(-1);
            dummy.next = head.next;
            helper(null, head, 0);
            return dummy.next;
        }

        private ListNode helper(ListNode prev, ListNode current, int depth) {//Here comes a strange problem, when enter into depth 7, the depth should be 6 after exitting from depth 7; But it isn't.
            //boundary
            if (current == null) {
                return null;
            }
            //This's wrong because of depth++ : ListNode nextHead = helper(current, current.next, depth++);
            ListNode nextHead = helper(current, current.next, ++depth);
            if (depth % 2 == 0) {
                prev.next = nextHead;
                current.next = prev;
                return current;
            } else {
                return nextHead;
            }
        }

        public ListNode rightAnswer(ListNode head) {
            //
            ListNode curr = head;
            ListNode next = head.next;
            //swap
            curr = rightAnswer(next.next);
            curr.next = curr;
            return next;
        }
    }
}
