package daily_problems;

public class PlusOne66 {
    public static void main(String[] args) {
        Solution solution = new Solution();
        int[] result = solution.plusOne(new int[]{1,2,3});
        for (int i = 0; i < result.length; i++) {
            System.out.print(result[i] + ",");
        }
    }
    static class Solution {
        public int[] plusOne(int[] digits) {
            for (int i = digits.length - 1; i <= 0; i--) {
                if (digits[i] == 9) {
                    digits[i] = 0;
                } else {
                    digits[i]++;
                    return digits;
                }
            }
            digits = new int[digits.length + 1];
            digits[0] = 1;
            return digits;
        }
    }
}

