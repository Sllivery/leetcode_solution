package daily_problems;

public class MaximumProductSubarray152 {
    public static void main(String[] args) {

    }

    static class Solution {
        //动态规划的核心就是看出子问题，如果我们定义了一个递归式，那么子问题能够记录以前的状态，意味着不需要回头。
        public int maxProduct(int[] nums) {
            int maxSoFar = nums[0];
            int minSoFar = nums[0];
            int result = nums[0];
            for (int i = 1; i < nums.length; i++) {
                int product = maxSoFar * nums[i];
                maxSoFar = Math.max(nums[i], Math.max(product, minSoFar * nums[i]));
                minSoFar = Math.min(nums[i], Math.min(product, minSoFar * nums[i]));
                if (maxSoFar > result) {
                    result = maxSoFar;
                }
            }
            return result;
        }
    }
}
