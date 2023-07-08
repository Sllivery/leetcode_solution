package daily_problems;

public class MaximumSubarray53 {
    /*
    * Given an integer array nums, find the subarray
    * with the largest sum, and return its sum.
    * Input: nums = [-2,1,-3,4,-1,2,1,-5,4]
      Output: 6
      Explanation: The subarray [4,-1,2,1] has the largest sum 6.
    * */
    public static void main(String[] args) {
        Solution solution = new Solution();
        int[] test = {1};
        int i = solution.maxSubArray(test);
        System.out.println(i);
    }

    static class Solution {
        public int maxSubArray(int[] nums) {
            int[] globalMax = {Integer.MIN_VALUE};
            helper(nums, nums.length - 1, globalMax);
            return globalMax[0];
        }

        private int helper(int[] nums, int index, int[] globalMax) {
            if (index == 0) {
                globalMax[0] = nums[0];
                return nums[0];
            }
            int a = helper(nums, index - 1, globalMax) + nums[index];
            int b = nums[index];
            int localMax = Math.max(a, b);
            if (localMax > globalMax[0]) {
                globalMax[0] = localMax;
            }
            return localMax;
        }
    }
}
