package microsoft_q.sorting_searching;

public class SearchinRotatedSortedArray {
    public static void main(String[] args) {
        int[] test = {1};
        Solution solution = new Solution();
        int result = solution.search(test, 1);
        System.out.println(result);
    }

    static class Solution{
        public int search(int[] nums, int target) {
            if (nums.length == 1){
                return (target == nums[0]) ? 0 : -1;
            }
            int minIndex = findMinIndex(nums);
            if (target >= nums[minIndex] && target <= nums[nums.length-1]){ //the target belongs to the samll part
                return binarySearch(nums, target, minIndex, nums.length - 1);
            } else { // the target belongs to the big part
                return binarySearch(nums, target, 0, minIndex);
            }
        }

        private int binarySearch(int[]nums, int target, int left, int right){
            int middle = 0;
            while (left <= right) {
                middle = left + (right - left)/2;
                if (target == nums[middle]) {
                    return middle;
                }
                if (target > nums[middle]) {
                    left = middle+1;
                } else {
                    right = middle - 1;
                }
            };
            return -1;
        }

        private int findMinIndex(int[] nums) {
            int left = 0;
            int right = nums.length - 1;
            if (nums[left] < nums[right]) {
                return 0;
            }
            int middle;
            while (left <= right) {
                middle = left + (right - left) / 2;
                if (nums[middle + 1] < nums[middle]) {
                    return middle + 1;
                } else if (nums[middle - 1] > nums[middle]) {
                    return middle;
                } else if (nums[middle] > nums[0]) { //nums[left] > nums[right] is wrong. focus on this line
                    left = middle + 1;
                } else {
                    right = middle - 1;
                }
            }
            return -1;
        }
    }
}
