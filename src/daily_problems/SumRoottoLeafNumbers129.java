package daily_problems;

import utils.TreeNode;

public class SumRoottoLeafNumbers129 {
    public static void main(String[] args) {

    }

    static  class Solution {
        public int sumNumbers(TreeNode root) {
            int sum[] = {0};
            helper(sum, root, 0);
            return sum[0];
        }

        public void helper(int[] sum, TreeNode root, int current) {
            if (root.left == null && root.right == null) {
                sum[0] += current*10 + root.val;
                return;
            }
            current = current*10 + root.val;
            if (root.left != null) {
                helper(sum, root.left, current);
            }
            if (root.right != null) {
                helper(sum, root.right, current);
            }
        }
    }
}
