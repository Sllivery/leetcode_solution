package daily_problems;

import java.util.Arrays;

public class SingleNumberII137 {
    public static void main(String[] args) {
        int[] test = {0,1,0,1,0,1,99};
        Solution solution = new Solution();
        int i = solution.singleNumber(test);
        System.out.println(i);
    }

    static class Solution {
        public int singleNumber(int[] nums) {
            int slow = 0;
            int middle = slow + 1;
            int fast = slow + 2;
            Arrays.sort(nums);
            while (slow < nums.length) {
                if (slow == nums.length - 1 || nums[slow] != nums[middle]) {
                    return nums[slow];
                }
                if (nums[slow] == nums[middle] && nums[middle] == nums[fast]) {
                    slow += 3;
                    middle = slow + 1;
                    fast = slow + 2;
                }
            }
            return 0;
        }
    }
}
