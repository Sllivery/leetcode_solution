package daily_problems;

import utils.TreeNode;

import java.util.ArrayList;
import java.util.List;

public class RecoverBinarySearchTree99 {
    public static void main(String[] args) {

    }

    class Solution {
        public void recoverTree(TreeNode root) {
            /*
            determine which nodes are disorder
            swap them
            my general idea is correct, what confuse me is that I don't know how to identify the nodes needed to swap.
            And this problem needs three knowledge.
            1.The effect of traversal way to array representation of BST
            2.Find the disorder pair in an array
            3.How to swap?
            */
            List<Integer> list = new ArrayList<>();
            traversal(list, root);
            int[] pair = findTwoSwapped(list);
            recover(root, 2, pair[0], pair[1]);
        }

        public void traversal(List<Integer> list, TreeNode root) {
            if (root == null) {
                return;
            }
            traversal(list, root.left);
            list.add(root.val);
            traversal(list, root.right);
        }

        public int[] findTwoSwapped(List<Integer> nums) {
            int n = nums.size();
            int x = -1, y = -1;
            boolean swapped_first_occurrence = false;
            for(int i = 0; i < n - 1; ++i) {
                if (nums.get(i + 1) < nums.get(i)) {
                    y = nums.get(i + 1);
                    if (!swapped_first_occurrence) {
                        x = nums.get(i);
                        swapped_first_occurrence = true;
                    } else {
                        break;
                    }
                }
            }
            return new int[]{x, y};
        }

        public void recover(TreeNode r, int count, int x, int y) {
            if (r != null) {
                if (r.val == x || r.val == y) {
                    r.val = r.val == x ? y : x;
                    if (--count == 0) return;
                }
                recover(r.left, count, x, y);
                recover(r.right, count, x, y);
            }
        }

    }
}
