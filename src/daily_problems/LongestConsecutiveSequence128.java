package daily_problems;

import java.util.Arrays;

public class LongestConsecutiveSequence128 {
    public static void main(String[] args) {
        int[] test1 = {9,1,4,7,3,-1,0,5,8,-1,6};
        Solution solution = new Solution();
        int i = solution.longestConsecutive(test1);
        System.out.println(i);

    }
    static class Solution {
        public int longestConsecutive(int[] nums) {
            if (nums.length == 0) {
                return 0;
            }
            Arrays.sort(nums);
            int current = 0;
            int longest = 0;
            for (int i = 0; i < nums.length - 1; i++) {
                if (nums[i + 1] == nums[i] + 1) {
                    current++;
                } else if (nums[i] == nums[i + 1]) {
                    continue;
                } else {
                    if (current > longest) {
                        longest = current;
                    }
                    current = 0;
                }
            }
            return Math.max(current, longest) + 1;
        }
    }
}
