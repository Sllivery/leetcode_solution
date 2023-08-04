package daily_problems;

import utils.TreeNode;

public class MinimumDepthofBinaryTree111 {
    public static void main(String[] args) {

    }

    static class Solution {
        public int minDepth(TreeNode root) {
            if (root == null) return 0;
            if (root.left == null && root.right == null) {
                return 1;
            }

            if (root.left == null) {
                return 1 + minDepth(root.right);
            } else if (root.right == null) {
                return 1 + minDepth(root.left);
            }

            return 1 + Math.min(minDepth(root.left), minDepth(root.right));
        }
    }
}
