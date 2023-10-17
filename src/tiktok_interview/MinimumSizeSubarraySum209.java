package tiktok_interview;

import java.util.Arrays;
import java.util.Collections;
import java.util.Iterator;

public class MinimumSizeSubarraySum209 {
    public static void main(String[] args) {
        int target = 7;
        int[] nums = {2, 3, 1, 2, 4, 3};
        Solution solution = new Solution();
        int i = solution.minSubArrayLen(target, nums);
        System.out.println(i);
    }

    static class Solution {
        Integer[] memo;

        public int minSubArrayLen(int target, int[] nums) {
            int left = 0;
            int right = 0;
            int sum = 0;
            int minLen = Integer.MAX_VALUE;
            while (right < nums.length) {
                sum += nums[right];
                while (sum >= target) {
                    minLen = Math.min(right - left + 1, minLen);
                    sum -= nums[left];
                    left++;
                }
                right++;
            }
            return minLen == Integer.MAX_VALUE ? 0 : minLen;
        }

        public int minSubArrayLenV1(int target, int[] nums) {
            //target = 7, nums = [2,3,1,2,4,3]
            memo = new Integer[nums.length];
            Arrays.fill(memo, Integer.MAX_VALUE);
            dp(target, 0, nums);
            for (Integer integer : memo) {
                System.out.println(integer);
            }
            return 0;
        }

        private int dp(int target, int index, int[] nums) {
            //basice case. target <= 0
            if (target <= 0) {
                memo[index] = 1;
                return 1;
            }
            if (index == nums.length && memo[index - 1] == Integer.MAX_VALUE) {
                return 0;
            }
            if (memo[index] != Integer.MAX_VALUE) {
                return memo[index];
            }
            int length = Integer.MAX_VALUE;
            int temp;
            //legal operations
            for (int i = index + 1; i < nums.length; i++) {
                temp = dp(target - nums[i], i, nums);
                if (temp < length) {
                    length = temp;
                }
            }
            memo[index] = length == Integer.MAX_VALUE ? Integer.MAX_VALUE : length + 1;
            return memo[index];
        }
    }
}
