package daily_problems;

import utils.TreeNode;

public class PathSum112 {
    public static void main(String[] args) {

    }

    class Solution {
        public boolean hasPathSum(TreeNode root, int targetSum) {
            boolean[] result = {false};
            helper(root, 0, result, targetSum);
            return result[0];
        }

        public void helper(TreeNode root, int currentSum, boolean[] result, int targetSum) {
            if (root == null || result[0]) {
                return;
            }
            if (currentSum + root.val == targetSum && root.left == null && root.right == null) {
                result[0] = true;
                return;
            }
            helper(root.left, currentSum + root.val, result, targetSum);
            helper(root.right, currentSum + root.val, result, targetSum);
        }
    }
}
