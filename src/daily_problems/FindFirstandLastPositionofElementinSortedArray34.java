package daily_problems;

public class FindFirstandLastPositionofElementinSortedArray34 {

    private int test;

    public static void main(String[] args) {
        int[] nums = {1,3};
        int target = 1;
        Solution solution = new Solution();
        int[] result = solution.searchRange(nums, target);
        for (int i = 0; i < result.length; i++) {
            System.out.println(result[i]);
        }
    }

    static class Solution{
        public int[] mySearchRange(int[] nums, int target) {
            if (nums.length == 0) {
                return new int[]{-1, -1};
            }
            if (nums[0] == nums[nums.length - 1] && target == nums[0]) {
                return new int[]{0, nums.length - 1};
            }
            //binary search find the target
            int left = 0;
            int right = nums.length -1;
            int middle = 0;
            boolean flag = false;
            while (left <= right) {
                middle = left + (right - left)/2;
                if (target == nums[middle]) {
                    flag = true;
                    break;
                }
                if (target > nums[middle]) {
                    left = middle + 1;
                } else {
                    right = middle - 1;
                }
            }
            if (!flag) {
                return new int[]{-1,-1};
            }
            //expand the range of both side
            int leftExpand = middle;
            int rightExpand = middle;
            int leftNext = leftExpand - 1;
            int rightNext = rightExpand + 1;
            if (leftNext < 0) {
                leftNext = 0;
            }
            if (rightNext > nums.length - 1) {
                rightNext = nums.length - 1;
            }
            while (nums[leftNext] == nums[middle] || nums[rightNext] == nums[middle]) {
                if (nums[--leftExpand] != nums[middle]) {
                    leftExpand++;
                }
                if (nums[++rightExpand] != nums[middle]) {
                    rightExpand--;
                }
                leftNext = leftExpand - 1;
                rightNext = rightExpand + 1;
                if (leftNext < 0) {
                    leftNext = 0;
                }
                if (rightNext > nums.length - 1) {
                    rightNext = nums.length - 1;
                }
            }
            return new int[]{leftExpand, rightExpand};
        }

        public int[] searchRange(int[] nums, int target) {
            int[] result = {-1, -1};
            if (nums.length == 0) {
                return result;
            }
            //find the first index
            result[0] = helper(nums, target, true);
            if (result[0] == -1) {
                return result;
            }
            //find the last index
            result[1] = helper(nums, target, false);
            return result;
        }

        private int helper(int[] nums, int target, boolean isFirst) {
            int left = 0;
            int right = nums.length;
            int middle = 0;
            while (left <= right) {
                middle = left + (right - left)/2;
                if (nums[middle] == target) {
                    if (isFirst) {
                        if (left == middle || nums[middle - 1] != target) {//?
                            return middle;
                        } else {
                            right = middle - 1; //?
                        }
                    } else {
                        if (right == middle || nums[middle + 1] != target) {//?
                            return middle;
                        } else {
                            left = middle + 1; //?
                        }
                    }
                } else if (nums[middle] > target) {
                    right = middle - 1;
                } else {
                    left = middle + 1;
                }
            }
            return -1;
        }
    }
}
