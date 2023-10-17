package tiktok_interview;

import utils.TreeNode;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;

public class BinaryTreeMaximumPathSum124 {
    public static void main(String[] args) {
        TreeNode root = new TreeNode(1);
        TreeNode left = new TreeNode(2);
        TreeNode right = new TreeNode(3);
        root.left = left;
        root.right = right;
        Solution solution = new Solution();
        solution.maxPathSum(root);
    }

    static class Solution {
        private int maxSum;

        public int maxPathSum(TreeNode root) {
            maxSum = Integer.MIN_VALUE;
            gainFromSubtree(root);
            return maxSum;
        }

        // post order traversal of subtree rooted at `root`
        private int gainFromSubtree(TreeNode root) {
            if (root == null) {
                return 0;
            }

            // add the path sum from left subtree. Note that if the path
            // sum is negative, we can ignore it, or count it as 0.
            // This is the reason we use `Math.max` here.
            int gainFromLeft = Math.max(gainFromSubtree(root.left), 0);

            // add the path sum from right subtree. 0 if negative
            int gainFromRight = Math.max(gainFromSubtree(root.right), 0);

            // if left or right path sum are negative, they are counted
            // as 0, so this statement takes care of all four scenarios
            maxSum = Math.max(maxSum, gainFromLeft + gainFromRight + root.val);

            // return the max sum for a path starting at the root of subtree
            return Math.max(gainFromLeft + root.val, gainFromRight + root.val);
        }

        public int maxPathSumMy(TreeNode root) {
            //convert tree into an array with preorder traversal
            List<Integer> array = new ArrayList<>();
            preorder(array, root);
            Integer[] dpTable = new Integer[array.size()];
            //use dp to solve max combination of this array
            dp(array, dpTable);
            return Collections.max(Arrays.asList(dpTable));
        }

        private void dp(List<Integer> array, Integer[] dpTable) {
            dpTable[dpTable.length - 1] = array.get(array.size() - 1);
            for (int i = dpTable.length - 2; i >= 0; i--) {
                dpTable[i] = Math.max(array.get(i), array.get(i) + dpTable[i + 1]);
            }
        }

        private void preorder(List<Integer> array, TreeNode root) {
            if (root == null) {
                return;
            }
            preorder(array, root.left);
            preorder(array, root.right);
            array.add(root.val);
        }
    }
}
