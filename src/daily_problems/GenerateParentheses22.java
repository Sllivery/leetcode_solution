package daily_problems;

import java.util.ArrayList;
import java.util.List;

public class GenerateParentheses22 {
    public static void main(String[] args) {
        Solution solution = new Solution();
        List<String> re = solution.generateParenthesis(2);
        System.out.println(re.toString());
    }

    static class Solution {
        public List<String> myGenerateParenthesis(int n) {
            StringBuilder string = new StringBuilder();
            ArrayList<String> result = new ArrayList<>();
            int depth = 0;
            helper(depth, n, string, result);
            return result;
        }

        private void helper(int depth, int n, StringBuilder string, ArrayList<String> result) {
            //boundary
            if (depth == 2 * n && isValid(string)) {
                result.add(string.toString());
                return;
            } else if (isValid(string)) { //it's totally wrong. The computation of depth is wrong, the condition logic is wrong.
                //Basicly, if my algorithm got in dead end like this, just completely abandon the idea.
                helper(depth + 1, n, string.append("("), result);
                helper(depth + 1, n, string.append(")"), result);
            } else {
                return;
            }
        }


        private boolean isValid(StringBuilder string) {
            //count the right brackets and the left
            int count = 0;
            for (int i = 0; i < string.length(); i++) {
                if (string.charAt(i) == '(') {
                    count++;
                } else {
                    count--;
                }
            }
            return count == 0;
        }

        //now the question is: 1.what's boudary of this recursive? 2.how do i judge there's no hope construct valid brackets?
        public List<String> generateParenthesis(int n) {
            List<String> result = new ArrayList<>();
            StringBuilder builder = new StringBuilder();
            helper2(result, builder, n, 0, 0);
            return result;
        }

        private void helper2(List<String> result, StringBuilder builder, int max, int right, int left) {
            //we can set the boundary based on the length of current string
            if (2 * max == builder.length()) {
                result.add(builder.toString());
                return;
            }
            if (right < max) {
                builder.append("(");
                helper2(result, builder, max, right + 1, left);
                builder.deleteCharAt(builder.length() - 1);
            }
            if (left < right) {
                builder.append(")");
                helper2(result, builder, max, right, left+1);
                builder.deleteCharAt(builder.length() - 1);
            }
        }
    }
}
