package daily_problems;

import java.util.Arrays;

public class TwoSumIIInputArrayisSorted167 {
    public static void main(String[] args) {
        int[] array = {2, 7, 11, 15};
        int i = Arrays.binarySearch(array, 9);
        System.out.println(Math.abs(i + 1));
    }

    static class Solution {
        public int[] twoSum(int[] numbers, int target) {
            int left = 0;
            int right = numbers.length - 1;
            while (left < right) {
                int temp = numbers[left] + numbers[right];

                if (temp == target) {
                    return new int[]{left + 1, right + 1};
                } else if (temp > target) {
                    //too big, make the sum samller
                    right--;
                } else {
                    //too small, make the sum bigger
                    left ++;
                }
            }
            return null;
        }
    }
}
