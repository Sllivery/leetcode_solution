package daily_problems;

import java.util.ArrayList;
import java.util.List;

public class RestoreIPAddresses93 {
    //todo
    public static void main(String[] args) {
        String test = "1234";
        System.out.println(test.substring(1,2));
        //System.out.println(test.substring(0,0));
    }

    static class Solution {
        public List<String> restoreIpAddresses(String s) {
            StringBuilder builder = new StringBuilder();
            List<String> result = new ArrayList<>();
            backtrack(builder, result, s, 0);
            return result;
        }

        public void backtrack(StringBuilder builder, List<String> result, String s, int x) {
            //possible cases: one digital, two digital, three digitial
            //if (step isn't one && starts with a zero) return;
            //if (currentString < 0 || currentString > 255) return;
            //if (index == s.length - 1) result.add(new String(Stringbuilder.toString))

            //go one step further
            char c = s.charAt(x);
            builder.append(c);
            //backtrack one step
            //go two steps further if enough strings remain
            String substring = s.substring(x, x + 1);
            builder.append(substring);
            //backtrack two steps
            //go three steps further if enough strings remain
            //backtrack three steps
        }
    }
}
