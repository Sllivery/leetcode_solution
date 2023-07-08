package daily_problems;

import java.util.Stack;

public class SimplifyPath71 {
    public static void main(String[] args) {
        String test = "/a/b/c/.././././//d";
        String[] split = test.split("/");

        Solution solution = new Solution();
        String s = solution.simplifyPath("/../");
        System.out.println(s);
    }

    static class Solution {
        public String simplifyPath(String path) {
            String[] split = path.split("/");
            Stack<String> stack = new Stack<>();
            StringBuilder result = new StringBuilder();
            for (String s : split) {
                if (s.equals("..")) {//if .. pop the last pushed
                    if (!stack.isEmpty()) {
                        stack.pop();
                    }
                    continue;
                } else if (s.equals("") || s.equals(".")) {
                    continue;
                } else {
                    stack.push(s);
                }
            }
            if (stack.isEmpty()) {
                return "/";
            }
            for (String s : stack) {
                String current = "/" + s;
                result.append(current);
            }
            return result.toString();
        }
    }
}
