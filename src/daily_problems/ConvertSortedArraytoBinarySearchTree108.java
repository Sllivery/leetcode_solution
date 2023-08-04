package daily_problems;

import utils.TreeNode;

public class ConvertSortedArraytoBinarySearchTree108 {
    public static void main(String[] args) {
        int[] array = {-10, -3, 0, 5, 9};
        Solution solution = new Solution();
        TreeNode treeNode = solution.recursionMethod(array);
        System.out.println("blank");
    }

    static class Solution{
        public TreeNode sortedArrayToBST(int[] nums) {
            int left = 0;
            int right = nums.length - 1;
            int mid = (nums.length - 1) / 2;
            if (mid != 0) {
                left = mid - 1;
            }
            if (mid != nums.length - 1) {
                right = mid + 1;
            }
            TreeNode root = new TreeNode(nums[mid]);
            for (; left >= 0; left--) {
                TreeNode newNode = new TreeNode(nums[mid]);
            }
            for (; right < nums.length; right++) {

            }
            return new TreeNode(1);
        }

        public TreeNode recursionMethod(int[] nums) {
            int mid = (nums.length - 1) / 2;
            int left = 0;
            int right = nums.length - 1;
            return helper(nums, left, right);
        }

        public TreeNode helper(int[] nums, int left, int right) {
            if (left > right) {
                return null;
            }
            int mid = (left + right) / 2;
            TreeNode parent = new TreeNode(nums[mid]);
            parent.left = helper(nums, left, mid-1);
            parent.right = helper(nums, mid+1, right);
            return parent;
        }
    }
}
