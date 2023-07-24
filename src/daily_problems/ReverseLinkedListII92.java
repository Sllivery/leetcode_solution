package daily_problems;

import utils.ListNode;

public class ReverseLinkedListII92 {
    public static void main(String[] args) {
        int[] array = {3,5};
        Solution solution = new Solution();
        ListNode listNode = solution.reverseBetween(new ListNode(array), 1,2);
        System.out.println(listNode);
    }

    static class Solution {
        public ListNode reverseBetween(ListNode head, int left, int right) {
            int index = 1;
            int startIndex = 0;
            ListNode pointer = head;
            ListNode leftBreakPoint = new ListNode(Integer.MIN_VALUE);
            ListNode rightBreakPoint = null;
            ListNode startPoint = null;
            while (pointer != null) {
                if (index == left - 1) {
                    leftBreakPoint = pointer;
                }
                if (index == right + 1) {
                    rightBreakPoint = pointer;
                }
                if (index == left) {
                    startPoint = pointer;
                    startIndex = index;
                }
                pointer = pointer.next;
                index++;
            }
            ListNode partialStart = helper(null, startPoint, startIndex, right);
            //如果右边有才连接
            if (right < index - 1) {
                pointer = partialStart;
                while (pointer.next != null) {
                    pointer = pointer.next;
                }
                pointer.next = rightBreakPoint;
            }
            //如果左边有才连接
            if (leftBreakPoint.val != Integer.MIN_VALUE) {
                leftBreakPoint.next = partialStart;
                return head;
            } else {
                return partialStart;
            }
        }

        public ListNode helper(ListNode lastNode, ListNode pointer, int index, int right) {
            if (index == right + 1) {
                return lastNode;
            }
            ListNode newHead = helper(pointer, pointer.next, index+1, right);
            if (lastNode != null) {
                lastNode.next = null;
            }
            pointer.next = lastNode;
            return newHead;
        }
    }
}
