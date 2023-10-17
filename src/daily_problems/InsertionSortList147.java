package daily_problems;

import utils.ListNode;

import java.util.LinkedList;
import java.util.Stack;

public class InsertionSortList147 {
    public static void main(String[] args) {
        int[] array = {4, 2, 1, 3};
        ListNode head = new ListNode(array);
        Solution solution = new Solution();
        ListNode listNode = solution.insertionSortList(head);
        System.out.println(listNode);
    }

    static class Solution {
        public ListNode insertionSortListSilly(ListNode head) {
            //double stack idea
            LinkedList<ListNode> firstStack = new LinkedList<>();
            LinkedList<ListNode> secondStack = new LinkedList<>();
            firstStack.push(head);
            head = head.next;
            while (head != null) {
                if (head.val < head.next.val) {
                    head = head.next;
                } else {
                    while (!firstStack.isEmpty()) {
                        if (firstStack.peek().val < head.val) {
                            break;
                        } else {
                            ListNode popNode = firstStack.pop();
                            ListNode popNext = head.next;
                            head.next = popNode;
                            popNode.next = popNext;
                            firstStack.push(head);
                            secondStack.push(popNode);
                        }
                    }
                    while (!secondStack.isEmpty()){
                        firstStack.push(secondStack.pop());
                    }
                }
            }
            return firstStack.getLast();
        }

        public ListNode insertionSortList(ListNode head) {
            ListNode zero = new ListNode(-1);
            zero.next = head;
            ListNode prev = head;
            head = head.next;
            while (head != null) {

            }
            return null;
        }
    }
}
