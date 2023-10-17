package tiktok_interview;

import utils.ListNode;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class MergekSortedLists23 {
    public static void main(String[] args) {
        int[][] test = {{1, 4, 5}, {1, 3, 4}, {2, 6}};
        ListNode[] testNode = new ListNode[3];
        int index = 0;
        for (int[] ints : test) {
            testNode[index] = new ListNode(ints);
            index++;
        }
        Solution solution = new Solution();
        ListNode listNode = solution.mergeKLists(testNode);
        System.out.println(listNode);
    }

    static class Solution {
        public ListNode mergeKLists(ListNode[] lists) {
            List<Integer> list = new ArrayList<>();
            for (ListNode listNode : lists) {
                while (listNode != null) {
                    list.add(listNode.val);
                    listNode = listNode.next;
                }
            }

            Collections.sort(list);
            ListNode result = new ListNode(-1);
            ListNode pointer = result;
            for (Integer integer : list) {
                pointer.next = new ListNode(integer);
                pointer = pointer.next;
            }
            return result.next;
        }
    }
}
