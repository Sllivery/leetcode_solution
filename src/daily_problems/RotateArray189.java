package daily_problems;

import java.util.Arrays;

public class RotateArray189 {
    public static void main(String[] args) {
        int[] test = {-1,-100,3,99};
        Solution solution = new Solution();
        solution.rotate(test, 2);
        System.out.println(Arrays.toString(test));
    }
    static class Solution {
        public void rotate(int[] nums, int k) {
            //I combined the two function and it passed.
        }
        public void rotateTLE(int[] nums, int k) {
            //every time only move one item to the front, but the time complexity is k*n
            //it turns out TLE
            int length = nums.length;
            if (length == 1) {
                return;
            }
            if (k > nums.length) {
                while (k > 0) {
                    int rear = nums[length - 1];
                    int index = length - 2;
                    while (index >= 0) {
                        nums[index + 1] = nums[index];
                        index--;
                    }
                    nums[0] = rear;
                    k--;
                }
            } else {
                //record the numbers needed to rotate
                int[] record = new int[k];
                int index = nums.length - 1;
                while (k > 0) {
                    record[k-1] = nums[index];
                    k--;
                    index--;
                }
                //push every number back
                int left = nums.length - 1;
                while (index >= 0) {
                    nums[left] = nums[index];
                    left--;
                    index--;
                }
                //fill the rotated nubmers
                for (; k < record.length; k++) {
                    nums[k] = record[k];
                }
            }

        }
        public void rotateWrong(int[] nums, int k) {
            //doesn't work, this function create an illusion of rotating the array.
            if (nums.length == 1) {
                return;
            }
            //record the numbers needed to rotate
            int[] record = new int[k];
            int index = nums.length - 1;
            while (k > 0) {
                record[k-1] = nums[index];
                k--;
                index--;
            }
            //push every number back
            int left = nums.length - 1;
            while (index >= 0) {
                nums[left] = nums[index];
                left--;
                index--;
            }
            //fill the rotated nubmers
            for (; k < record.length; k++) {
                nums[k] = record[k];
            }
        }
    }
}
