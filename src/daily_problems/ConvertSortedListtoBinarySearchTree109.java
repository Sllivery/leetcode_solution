package daily_problems;

import utils.ListNode;
import utils.TreeNode;

import java.util.ArrayList;


public class ConvertSortedListtoBinarySearchTree109 {
    public static void main(String[] args) {
        ListNode head = new ListNode(new int[]{-10, -3, 0, 5, 9});
        Solution solution = new Solution();
        solution.sortedListToBST(head);
    }

    static class Solution {
        ArrayList<Integer> list;
        public TreeNode sortedListToBST(ListNode head) {
            list = new ArrayList<>();
            while (head != null) {
                list.add(head.val);
                head = head.next;
            }
            return helper(0, list.size() - 1);
        }

        public TreeNode helper(int left, int right) {
            if (left > right) {
                return null;
            }
            int mid = (left + right) / 2;
            TreeNode parent = new TreeNode(list.get(mid));
            parent.left = helper(left, mid - 1);
            parent.right = helper(mid + 1, right);
            return parent;
        }
    }
}
