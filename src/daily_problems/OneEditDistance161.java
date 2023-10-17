package daily_problems;

public class OneEditDistance161 {
    public static void main(String[] args) {
        Solution solution = new Solution();
        boolean oneEditDistance = solution.isOneEditDistance("a", "");
        System.out.println(oneEditDistance);
    }

    static class Solution {
        public boolean isOneEditDistance(String s, String t) {
            //length differs by one -> try to insert
            //length is equal -> try to repalce

            //for convience of operation, make sure s is the shorter one.
            if (s.length() - t.length() > 0) {
                isOneEditDistance(t, s);
            }

            if (t.length() - s.length() > 1) {
                return false;
            }

            if (s.length() == 0 && t.length() == 1) {
                return true;
            }

            for (int i = 0; i < s.length(); i++) {
                if (s.charAt(i) != t.charAt(i)) {
                    if (s.length() == t.length()) {
                        return s.substring(i + 1).equals(t.substring(i + 1));
                    } else {
                        return s.substring(i).equals(t.substring(i + 1));
                    }
                }
            }

            //if like this: ab ab -> false
            return s.length() + 1 == t.length();
        }
    }
}
