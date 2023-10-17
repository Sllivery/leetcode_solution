package daily_problems;

import java.util.LinkedList;
import java.util.Stack;

public class EvaluateReversePolishNotation150 {
    public static void main(String[] args) {
        String[] test = {"10","6","9","3","+","-11","*","/","*","17","+","5","+"};
        Solution solution = new Solution();
        int i = solution.evalRPN(test);
        System.out.println(i);
    }

    static class Solution {
        public int evalRPN(String[] tokens) {
            Stack<String> stack = new Stack<>();
            for (String token : tokens) {
                switch (token) {
                    case "+":
                        evaluate(stack.pop(), stack.pop(), stack, "+");
                        break;
                    case "-":
                        evaluate(stack.pop(), stack.pop(), stack, "-");
                        break;
                    case "*":
                        evaluate(stack.pop(), stack.pop(), stack, "*");
                        break;
                    case "/":
                        evaluate(stack.pop(), stack.pop(), stack, "/");
                        break;
                    default:
                        stack.push(token);
                }
            }
            return Integer.parseInt(stack.pop());
        }

        private void evaluate(String second, String first, Stack<String> stack, String operator) {
            Integer result = 0;
            if (operator.equals("+")) {
                result = Integer.parseInt(first) + Integer.parseInt(second);
            } else if (operator.equals("-") ) {
                result = Integer.parseInt(first) - Integer.parseInt(second);
            } else if (operator.equals("*")) {
                result = Integer.parseInt(first) * Integer.parseInt(second);
            } else if (operator.equals("/")) {
                result = Integer.parseInt(first) / Integer.parseInt(second);
            }
            String resultS = String.valueOf(result);
            stack.push(resultS);
        }
    }
}
