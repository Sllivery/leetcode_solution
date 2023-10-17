package daily_problems;

public class FindPeakElement162 {
    public static void main(String[] args) {
        Solution solution = new Solution();
        int peakElement = solution.findPeakElement(new int[]{1, 2, 3, 1});
        System.out.println(peakElement);
    }

    static class Solution {
        //这题难在如何证明二分查找能够定位到一个极点 -> 找到最大值也行 -> 每次都把小的那部分剔除
        public int findPeakElement(int[] nums) {
            return helper(nums, 0, nums.length - 1);
        }

        private int helper(int[] nums, int left, int right) {
            //留着最大值 -> 在削减时不+1 -> right最终会和left相遇
            //原来这样有个问题，在第二个递归入口如果不middle+1，right 不会相遇。要保留的是大的那个。如果nums[middle]是小的那个，不用留。
            if (right == left) {
                return right;
            }
            int middle = (right + left) / 2;
            if (nums[middle] > nums[middle + 1]) {
                //削减掉右边
                return helper(nums, left, middle);
            } else {
                //这种情况nums[middle]是小的那个情况，所以需要+1，不需要再参与运算了。
                return helper(nums, middle + 1, right);
            }
        }
    }
}
