package daily_problems;

public class JumpGameII45 {
    public static void main(String[] args) {
        int[] nums = {2,3,1,1,4};
        Solution solution = new Solution();

        System.out.println(solution.jump(nums));
    }

    /**
     * my idea:
     * at first, i come up with greedy
     * but as i know, greedy can't be applied to global optimizied solution
     * so i did some google, and dp is a 'smart' version of greedy
     *
     * but the code doesn't work, even I don't understand what I wrote
     *
     * and the solutions have many greedy
     * q1: why can they use greedy
     * q2: what's the logic of their code
     * q3: how to modify my code so that it works
     */
    static class Solution {
        public int jump(int[] nums) {
            return helper(0, nums.length, nums);
        }

        private int helper(int currentIndex, int distance, int[] nums) {
            if (distance == 0) {
                return 0;
            }
            int availableSteps = nums[currentIndex];
            int[] resultArray = new int[availableSteps];
            for (int i = 1, j = 0; i <= availableSteps && j < availableSteps; i++, j++) {
                resultArray[j] = helper(currentIndex+i, distance - i, nums) + 1;
            }
            return min(resultArray);
        }

        private int min(int[] array) {
            int result = array[0];
            for (int i : array) {
                if (i < result) {
                    result = i;
                }
            }
            return result;
        }
    }
}
