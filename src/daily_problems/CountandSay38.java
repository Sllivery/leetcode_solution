package daily_problems;

import java.util.*;

public class CountandSay38 {
    public static void main(String[] args) {
        Solution solution = new Solution();
        System.out.println(solution.helper(5));
    }

    static class Solution{
        public String countAndSay(int n) {
            return helper(n);
        }

        private String helper(int n) {
            if (n == 1) {
                return "1";
            }

            String previous = helper(n - 1);
            //decomposite the previous number, liske 11, we say one 1, need to consider the order. from left to right.
            //construct new number
            char currentChar;
            char lastTimeChar = previous.charAt(0);
            int numbers = 1;
            StringBuilder builder = new StringBuilder();
            for (int i = 1; i < previous.length(); i++) {
                currentChar = previous.charAt(i);
                if (currentChar == lastTimeChar) {
                    numbers++;
                } else {
                    builder.append(numbers);
                    builder.append(lastTimeChar);
                    numbers = 1;
                }
                lastTimeChar = currentChar;
            }
            builder.append(numbers);
            builder.append(lastTimeChar);
            return builder.toString();
        }
    }
}
