package daily_problems;

import utils.TreeNode;


public class BalancedBinaryTree110 {
    public static void main(String[] args) {

    }

    static class Solution {
        public boolean isBalanced(TreeNode root) {
            boolean[] result = {true};
            helper(root, result);
            return result[0];
        }

        public int helper(TreeNode root, boolean[] result) {
            if (root == null) {
                return 0;
            }
            //get left substree's depth
            int depthLeft = helper(root.left, result);
            //get right substree's depth
            int depthRight = helper(root.right, result);
            if (Math.abs(depthLeft - depthRight) >= 2) {
                result[0] = false;
            }
            //get current depth
            return Math.max(depthLeft + 1, depthRight + 1);
        }
    }
}
