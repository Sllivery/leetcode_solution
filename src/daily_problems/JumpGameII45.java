package daily_problems;

public class JumpGameII45 {
    public static void main(String[] args) {
        int[] nums = {7,0,9,6,9,6,1,7,9,0,1,2,9,0,3};
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
     * and There are many greedy solutions
     * q1: why can they use greedy
     * q2: what's the logic of their code
     * q3: how to modify my code so that it works
     */
    static class Solution {
        /*
           做这一题的时候明显感觉逻辑异常的混乱，总结为什么想不明白。
           1.要清楚的明确整体思路
           2.要清楚的知道每个变量的作用
           3.不要用例子反推我应该怎么办
           4.乱猜,模糊的逻辑不要瞎写，一般都不对。对了也没有意义。
        */
        public int myJump(int[] nums) {
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

        public int myJump2(int[] nums) {
            int index = 0;
            int count = 0;
            if (nums.length == 1) {
                return count;
            }
            while (index < nums.length) {
                for (int i = 1; i <= nums[index]; i++) {
                    if (index + 1 == nums.length - 1) {
                        return count += 1;
                    }
                    if (index + nums[index] + nums[index + i] >= nums.length - 1) {
                        return count += 2;
                    }
                    index += nums[index];
                    count++;
                }
            }
            return count;
        }

        public int myJump3(int[] nums) {
            int index = 0;
            int count = 0;
            while (index < nums.length) {
                if (index == nums.length - 1) {
                    return count;
                }
                if (nums[index] + index >= nums.length - 1) {
                    count++;
                    break;
                }
                if (nums[index] >= nums[index + 1]) {
                    index += nums[index];
                } else {
                    index++;
                }
                count++;
            }
            return count;
        }

        public int myJump4(int[] nums) {
            if (nums.length == 1) {
                return 0;
            }
            int far = 0;
            int count = 0;
            for (int i = 0; i < nums.length; i++) {
                if (i + nums[i] > far){
                    far = i + nums[i];
                    count++;
                    if (far >= nums.length - 1) {
                        return count;
                    }
                }
            }
            return count;
        }

        public int jump(int[] nums) {
            int end = 0;
            int far = 0;
            int count = 0;
            for (int i = 0; i < nums.length; i++) {
                //far must be updated
                // if (i + nums[i] > far){ far = i + nums[i];}
                far = Math.max(i + nums[i], nums[i]);
                if (i == end) {
                    end = far;
                    count++;
                }
            }
            return count;
        }
    }
}
