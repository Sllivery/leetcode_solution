package daily_problems;

public class AddBinary67 {
    public static void main(String[] args) {
        Solution solution = new Solution();
        String s = solution.addBinary("111", "111");
        System.out.println(s);
    }

    static class Solution {
        public String addBinary(String a, String b) {
            int lengthA = a.length();
            int lengthB = b.length();
            if (lengthA < lengthB) {
                return addBinary(b, a);
            }

            int last = 0;
            StringBuilder result = new StringBuilder();
            int i;
            int j = a.length() - 1;
            for (i = b.length() - 1; i >= 0; i--) {
                int current = a.charAt(j) - '0' + b.charAt(i) - '0' + last;
                if (current <= 1) { //don't need to carry
                    result.append(current);
                    last = 0;
                    j--;
                } else if (current == 2) {
                    result.append('0');
                    last = 1;
                    j--;
                } else if (current == 3) {
                    result.append('1');
                    last = 1;
                    j--;
                }
            }
            for (; j >= 0; j--) {
                int current = (int) a.charAt(j) - '0' + last;
                if (current == 3) {
                    result.append('1');
                    last = 1;
                }
                else if (current == 2) {
                    result.append('0');
                    last = 1;
                } else {
                    result.append(current);
                    last = 0;
                }
            }
            if (last == 1) {
                result.append(last);
            }
            return result.reverse().toString();
        }
    }
}
