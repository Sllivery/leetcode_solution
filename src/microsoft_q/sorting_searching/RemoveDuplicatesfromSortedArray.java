package microsoft_q.sorting_searching;

import java.util.HashSet;

public class RemoveDuplicatesfromSortedArray {
    public static void main(String[] args) {
        Solution solution = new Solution();
        int[] nums = {1,1,2};
        solution.removeDuplicates(nums);
    }

    static class Solution{
        public int removeDuplicates(int[] nums) {
            int insertIndex = 1;
            for(int i = 1; i < nums.length; i++){
                if (nums[i - 1] != nums[i]){
                    nums[insertIndex] = nums[i];
                    insertIndex++;
                }
            }
            return insertIndex;
        }
    }
}
