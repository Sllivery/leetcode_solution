package microsoft_q.sorting_searching;

import java.util.Arrays;

public class MergeSortedArray {
    public static void main(String[] args) {
        Solution solution = new Solution();
        int[] nums1 = {0};
        int[] nums2 = {1};
        solution.merge(nums1, 0, nums2, 1);
        for (int i = 0; i < nums1.length; i++) {
            System.out.print(nums1[i] + " ");
        }
    }

    static class Solution{
        public void merge(int[] nums1, int m, int[] nums2, int n) {
            for (int index = m, index2 =0; index2 < nums2.length; index++,index2++) {
                nums1[index] = nums2[index2];
            }
            Arrays.sort(nums1);
        }
    }
}
