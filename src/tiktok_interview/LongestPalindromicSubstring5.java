package tiktok_interview;

public class LongestPalindromicSubstring5 {
    public static void main(String[] args) {
        String test = "babad";
        Solution solution = new Solution();
        String s = solution.longestPalindrome(test);
        System.out.println(s);
    }

    static class Solution {
        public String longestPalindrome(String s) {
            //babad
            //bab or aba

            //create a dp table and initiate it
            int length = s.length();
            boolean[][] memo = new boolean[length][length];
            int[] result = {0,0};
            //populate the talbe and we get the answer
            for (int i = 0; i < length; i++) {
                memo[i][i] = true;
            }
            //populate pairs whose length is two
            for (int i = 0; i < length - 1; i++) {
                if (s.charAt(i) == s.charAt(i + 1)) {
                    memo[i][i+1] = true;
                    result[0] = i;
                    result[1] = i + 1;
                }
            }
            //populate index pairs whose length from two to length - 1
            for (int i = 2; i < length; i++) {
                for (int j = 0; j < length - i; j++) {
                    if (s.charAt(j) == s.charAt(j + i) && memo[j + 1][j + i - 1]) {
                        memo[j][j + i] = true;
                        result[0] = j;
                        result[1] = j + i;
                    }
                }
            }
            return s.substring(result[0], result[1] + 1);
        }
    }
}
