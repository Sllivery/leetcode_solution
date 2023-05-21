package daily_problems;

public class NextPermutation31 {
    //the import idea of this problem is how to analyze the hidden pattern, this ability can apply to any prolbem.
    public static void main(String[] args) {
        Solution solution = new Solution();
        int[] test = {2,3,1,3,3};
        solution.nextPermutation(test);
        for (int i : test) {
            System.out.print(i + ",");
        }
    }

    static class Solution{
        public void nextPermutation(int[] nums) {
            int labelIndex = -1;
            for (int i = nums.length - 1; i > 0; i--) {
                if (nums[i] > nums[i - 1]) {
                    labelIndex = i - 1;
                    int justLargerIndex = 0;
                    int difference = Integer.MAX_VALUE;
                    for (int j = i; j < nums.length; j++) {
                        int abs = Math.abs(nums[j] - nums[i - 1]);
                        if (abs <= difference && nums[i - 1] < nums[j]) {
                            difference = abs;
                            justLargerIndex = j;
                        }
                    }
                    //swap
                    int temp = nums[i - 1];
                    nums[i - 1] = nums[justLargerIndex];
                    nums[justLargerIndex] = temp;
                    break;
                }
            }
            //reverse
            int left = labelIndex + 1;
            int right = nums.length - 1;
            while (left < right) {
                int temp = nums[left];
                nums[left] = nums[right];
                nums[right] = temp;
                left++;
                right--;
            }
        }
    }
}
