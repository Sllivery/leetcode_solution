package microsoft_q.arrays_strings;

import java.util.List;

public class TowSum {
    public static void main(String[] args) {
        int[] test = {2,7,11,15};
        int target = 9;
        Solution solution = new Solution();
        int[] result = solution.towSum(test, target);
        for (int i : result) {
            System.out.println(i);
        }
    }
    static class Solution{
        public int[] towSum(int[] nums, int target) {
            int result[] = new int[2];
            for (int i = 0; i < nums.length; i++) {
                for (int j = i+1; j < nums.length; j++) {
                    if (target == nums[i] + nums[j]) {
                        result[0] = i;
                        result[1] = j;
                    }
                }
            }
            return result;
        }
    }
}


