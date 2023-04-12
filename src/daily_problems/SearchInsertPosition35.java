package daily_problems;

public class SearchInsertPosition35 {
    public static void main(String[] args) {
        int[] test = {1, 2, 3, 4, 5, 6, 7};
        Solution solution = new Solution();
        System.out.println(solution.searchInsert(test, 1));
    }

    static class Solution {
        public int mySearchInsert(int[] nums, int target) {
            int left = 0;
            int right = nums.length - 1;
            int middle = 0;
            if (target > nums[right]) {
                return right + 1;
            }
            if (target < nums[0]) {
                return 0;
            }
            while (right - left > 1) {
                middle = left + (right - left)/2;
                if (target > nums[middle]) {
                    left = middle;
                } else if (target < nums[middle]) {
                    right = middle;
                }
            }
            if (target == nums[middle]) {
                return middle;
            } else if (target == nums[left]) {
                return left;
            } else if (target == nums[right]) {
                return right;
            } else if (target > nums[middle]) {
                return middle + 1;
            } else {
                return middle;
            }
        }

        public int searchInsert(int[] nums, int target) {
            //Compare to my solution which exceeds the time limit.
            //The difference foucses on boundary
            //I call it as implicit boundary. It's very tricky.
            //It's very hard to summarize the idea behind it, try to prove it from high-level.
            int left = 0;
            int right = nums.length - 1;
            int middle = 0;
            while (left <= right) {
                middle = left + (right - left)/2;
                if (target == nums[middle]) {
                    return middle;
                }
                if (target < nums[middle]){
                    right = middle - 1;
                } else {
                    left = middle + 1;
                }
            }
            return left;
        }
    }
}
