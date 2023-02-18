package microsoft_q.sorting_searching;

public class MergeSortedArray {
    public static void main(String[] args) {
        Solution solution = new Solution();
        int[] nums1 = {1,2,3,0,0,0};
        int[] nums2 = {2,5,6};
        solution.merge(nums1, 3, nums2, 3);
        for (int i = 0; i < nums1.length; i++) {
            System.out.println(nums1[i]);
        }
    }

    static class Solution{
        public void merge(int[] nums1, int m, int[] nums2, int n) {
            for (int index2 = 0, index1 = 0;index2 < n;index2 ++,index1 ++){
                if(nums2[index2] >= nums1[index1]){
                    //make a space for n[index2]
                    for(int i = m - 1; i > index1; i--){
                        nums1[i + 1] = nums1[i];
                    }
                    nums1[index1] = nums2[index2];
                }else{
                    for(int i = m - 1; i >= index1; i--){
                        nums1[i + 1] = nums1[i];
                    }
                    nums1[index1] = nums2[index2];
                }
            }
        }
    }
}
