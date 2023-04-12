package microsoft_q.linked_list;

import utils.ListNode;

import java.util.Stack;

public class AddTwoNumbers {
    public static void main(String[] args) {
        ListNode head1 = new ListNode(1);
        ListNode pointer = head1;
        for (int i = 0; i < 10; i++) {
            pointer.next = new ListNode(1);
            pointer = pointer.next;
        }

        ListNode head2 = new ListNode(1);
        ListNode pointer2 = head2;
        for (int i = 0; i < 10; i++) {
            pointer2.next = new ListNode(1);
            pointer2 = pointer2.next;
        }
        Solution solution = new Solution();
        solution.addTwoNumbers(head1, head2);
    }

    static class SolutionMyWrong {
        public ListNode addTwoNumbers(ListNode l1, ListNode l2) {
            //traverse two list, push every node into stack
            Stack<Integer> stack1 = new Stack<>();
            Stack<Integer> stack2 = new Stack<>();
            long number1 = 0;
            long number2 = 0;
            long result = 0;
            int digital;
            while (l1 != null) {
                stack1.push(l1.val);
                l1 = l1.next;
            }
            while (l2 != null) {
                stack2.push(l2.val);
                l2 = l2.next;
            }
            //get the first number by pop
            long temp = 0;
            while (!stack1.empty()) {
                digital = stack1.pop();
                temp *= 10;
                temp += digital;
            }
            number1 += temp;
            //get the second number by pop
            temp = 0;
            while (!stack2.empty()) {
                digital = stack2.pop();
                temp *= 10;
                temp += digital;
            }
            number2 += temp;
            //convert the result number to a list in reverse order
            result = number1 + number2;
            ListNode head = null;
            ListNode previous = null;
            while (result != 0) {
                if (head == null) {
                    long test = result % 10;
                    int test2 = (int) test;
                    head = new ListNode(test2);
                    previous = head;
                    result /= 10;
                }else {
                    long test = result % 10;
                    int test2 = (int) test;
                    ListNode current = new ListNode(test2);
                    previous.next = current;
                    previous = current;
                    result /= 10;
                }
            }
            return head;
        }
    }

    static class Solution{

        public ListNode addTwoNumbers(ListNode l1, ListNode l2){
            ListNode head = new ListNode(0);
            ListNode current = head;
            int carry = 0;
            while (l1 != null || l2 != null || carry != 0) {
                int x = (l1 != null) ? l1.val : 0;
                int y = (l2 != null) ? l2.val : 0;
                int sum = carry + x + y;
                carry = sum / 10;
                current.next = new ListNode(sum % 10);
                current = current.next;
                if (l1 != null)
                    l1 = l1.next;
                if (l2 != null)
                    l2 = l2.next;
            }
            return head.next;
        }

    }
}
