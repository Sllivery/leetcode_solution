package microsoft_q.sorting_searching;

public class SortColor {
    public static void main(String[] args) {

    }

    static class Solution{
        public void sortColors(int[] nums) {
            int p0 = 0;
            int p2 = nums.length - 1;
            int current = 0;
            while (current <= p2) {
                if (nums[current] == 0) {
                    int temp = nums[current];
                    nums[current] = nums[p0];
                    nums[p0] = temp;
                    p0++;
                    current++;
                }
                else if (nums[current] == 2) {
                    int temp = nums[current];
                    nums[current] = nums[p2];
                    nums[p2] = temp;
                    p2--;
                }else{
                    current++;
                }
            }
        }
    }
}
