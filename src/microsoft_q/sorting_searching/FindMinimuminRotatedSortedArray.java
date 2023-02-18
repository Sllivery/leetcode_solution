package microsoft_q.sorting_searching;

public class FindMinimuminRotatedSortedArray {
    public static void main(String[] args) {
        Solution solution = new Solution();
        int[] array = {3,4,5,1,2};
        int result = solution.findMin(array);
        System.out.println(result);
    }
    static class Solution{
        public int findMin(int[] nums) {
            if (nums.length == 1) {
                return nums[1];
            }
            int left = 0;
            int right = nums.length - 1;
            if (nums[left] < nums[right]) {
                return nums[0];
            }
            int middle;
            while (left <= right) {
                middle = left + (right - left) / 2;
                if (nums[middle + 1] < nums[middle]) {
                    return nums[middle + 1];
                } else if (nums[middle - 1] > nums[middle]) {
                    return nums[middle];
                } else if (nums[middle] > nums[0]) { //nums[left] > nums[right] is wrong. focus on this line
                    left = middle + 1;
                } else {
                    right = middle - 1;
                }
            }
            return Integer.MAX_VALUE;
        }
    }
}
