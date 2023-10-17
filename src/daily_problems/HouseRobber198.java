package daily_problems;

import java.util.Arrays;
import java.util.Collections;

public class HouseRobber198 {
    public static void main(String[] args) {
        int[] test = {2,7,9,3,1};
        Solution solution = new Solution();
        int rob = solution.rob(test);
        System.out.println(rob);
    }

    static class Solution {
        Integer[] max;

        public int rob(int[] nums) {
            //[1,2,3,1]
            //interval by one 1,3,1
            //basic case: at the end of these viallges
            //states: left viallges
            //operation: go to the next's next or anyone after the next's next
            //func:

            //what's the memo. 这种思路和我以前做的时候差不多，感觉容易撞上死胡同。怎么区分自顶向下或者向上？
            //the max profit at viallge 0, for example, is the max profit from viallge 2 to viallge n
            if (nums.length == 1) {
                return nums[0];
            }
            max = new Integer[nums.length];
            Arrays.fill(max, -1);
            dp(nums, 0);
            return Collections.max(Arrays.asList(max));
        }

        private int dp(int[] nums, int index) {
            if (index == nums.length - 1) {
                max[index] = nums[index];
                return nums[index];
            }
            if (max[index] != -1) {
                return max[index];
            }

            //rob the legal viallges
            int result = Integer.MIN_VALUE;
            int next = index + 2;
            while (next < nums.length) {
                int temp = dp(nums, next);
                next++;
                if (temp > result) {
                    result = temp;
                }
            }
            if (result == Integer.MIN_VALUE) {
                result = 0;
            }
            //record
            max[index] = result + nums[index];
            return max[index];
        }
    }
}
