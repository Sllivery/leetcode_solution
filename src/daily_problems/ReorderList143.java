package daily_problems;

import utils.ListNode;

import java.util.ArrayList;

public class ReorderList143 {
    public static void main(String[] args) {
        int[] array = {1,2,3,4,5};
        ListNode listNodes = new ListNode(array);
        Solution solution = new Solution();
        solution.reorderList(listNodes);
    }

    static class Solution {
        public void reorderList(ListNode head) {
            ListNode pointer = head;
            ArrayList<ListNode> list = new ArrayList<>();
            while (pointer != null) {
                list.add(pointer);
                pointer = pointer.next;
            }
            pointer = head;

            //L0 → L1 → … → Ln - 1 → Ln
            //L0 → Ln → L1 → Ln - 1 → L2 → Ln - 2 → …
            int sum = 0;
            int index = list.size() - 1;
            while (sum <= list.size()) {
                if (sum == list.size() - 1) {
                    break;
                }
                //get a rear part
                ListNode rearNode = list.get(index);
                //connect to the front part
                ListNode nodeAfterRearNode = pointer.next;
                pointer.next = rearNode;
                rearNode.next = nodeAfterRearNode;

                //update index and sum and pointer
                pointer = pointer.next.next;
                index--;
                sum+=2;
            }
            pointer.next = null;
            System.out.println(head);
        }
    }
}
