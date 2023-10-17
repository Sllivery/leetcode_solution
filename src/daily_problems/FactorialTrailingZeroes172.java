package daily_problems;

public class FactorialTrailingZeroes172 {
    public static void main(String[] args) {
        Solution solution = new Solution();
        int recursion = solution.trailingZeroes(13);
        System.out.println(recursion);
    }

    static class Solution {
        public int trailingZeroes(int n) {
            Long result = recursion(n);
            String s = String.valueOf(result);
            int index = s.length() - 1;
            int count = 0;
            while (s.charAt(index) == '0') {
                index--;
                count++;
            }
            return count;
        }

        private Long recursion(int n) {
            if (n == 1 || n == 0) {
                return 1L;
            }
            return n * recursion(n - 1);
        }
    }
}
