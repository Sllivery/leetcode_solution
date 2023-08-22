package daily_problems;

import java.util.Arrays;

public class SingleNumber136 {
    public static void main(String[] args) {
        Solution solution = new Solution();
        int[] array1 = {4,1,2,1,2};
        int i = solution.singleNumber(array1);
        System.out.println(i);
        int[] array2 = {4, 1, 2, 1, 2};
    }

    static class Solution {
        public int singleNumber(int[] nums) {
            if (nums.length == 1) {
                return nums[0];
            }
            Arrays.sort(nums);
            int slow = 0, fast = 1;
            while (fast < nums.length) {
                if (nums[slow] != nums[fast]) {
                    if (slow == 0) {
                        return nums[slow];
                    } else if (fast == nums.length - 1) {
                        return nums[fast];
                    } else {
                        if (nums[fast] == nums[fast + 1]) {
                            slow++;
                            fast++;
                        } else {
                            return nums[fast];
                        }
                    }
                }
                slow++;
                fast++;
            }
            return -1;
        }
    }
}
