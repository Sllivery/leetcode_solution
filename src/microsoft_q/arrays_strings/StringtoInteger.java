package microsoft_q.arrays_strings;

public class StringtoInteger {
    public static void main(String[] args) {
        Solution solution = new Solution();
        int re = solution.myAtoi("    -42");
        System.out.println(re);
    }

    static class Solution{
        public int myAtoi(String s) {
            int len = s.length();
            int index = 0;
            int sign = 1;
            int result = 0;
            //process space
            while (index < len && s.charAt(index) == ' ') {
                index++;
            }
            //process +-
            if (index < len && s.charAt(index) == '+') {
                sign = 1;
                index++;
            }else if (index < len && s.charAt(index) == '-'){
                sign = -1;
                index++;
            }
            //process digital
            while (index < len && Character.isDigit(s.charAt(index))){
                //this is the gorgerous thing in this code
                int digit = s.charAt(index) - '0';
                //process overflow
                if ((result > Integer.MAX_VALUE / 10) || (result == Integer.MAX_VALUE / 10 && digit > Integer.MAX_VALUE % 10)) {
                    return sign == 1 ? Integer.MAX_VALUE : Integer.MIN_VALUE;
                }
                result = result*10 +digit;
                index++;
            }
            return sign*result;
        }
    }
}
