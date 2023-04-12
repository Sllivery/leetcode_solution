package daily_problems;

import utils.ListNode;

public class MergeTwoSortedLists21 {
    public static void main(String[] args) {
        ListNode l1 = new ListNode(1);
        ListNode l2 = new ListNode(2);
        ListNode l3 = new ListNode(4);
        ListNode l4 = new ListNode(1);
        ListNode l5 = new ListNode(3);
        ListNode l6 = new ListNode(4);

        l1.next = l2;
        l2.next = l3;

        l4.next = l5;
        l5.next = l6;
        Solution solution = new Solution();
        ListNode result = solution.megerTwoLists(l1, l4);
        while (result.next != null) {
            System.out.print(result.val + "->");
            result = result.next;
        }
    }

    static class Solution{
        public ListNode myMergeTwoLists(ListNode list1, ListNode list2) {
            // intuitively, the pointers end up in chaos.
            // like, list1 and curr1 point to a same node.
            ListNode list3 = new ListNode();
            ListNode curr3 = list3;
            while (list1 != null && list2 != null) {
                ListNode curr1 = list1;
                ListNode curr2 = list2;
                if (list1.val >= list2.val){
                    curr2.next = curr1;
                    curr3.next = curr2;
                } else {
                    curr1.next = curr2;
                    curr3.next = curr1;
                }
                list1 = list1.next;
                list2 = list2.next;
                curr3 = curr3.next.next;
            }
            // here's the cause of the problem, however, i'don't why the iteration of list3 ends up infinite after this condition statement.
            // answer is that the list2 is infinite
            if (list1 != null) {
                curr3.next = list1;
            } else if (list2 != null) {
                curr3.next = list2;
            }
            return list3.next;
        }

        public ListNode megerTwoLists(ListNode list1, ListNode list2) {
            ListNode list3 = new ListNode(-1);
            ListNode prev = list3;

            while (list1 != null && list2 != null) {
                if (list1.val <= list2.val) {
                    prev.next = list1;
                    list1 = list1.next;
                } else{
                    prev.next = list2;
                    list2 = list2.next;
                }
                prev = prev.next;
            }

            prev.next = list1 == null ? list2 : list1;

            return list3.next;
        }
    }
}
