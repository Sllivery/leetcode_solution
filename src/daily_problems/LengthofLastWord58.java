package daily_problems;

public class LengthofLastWord58 {
    public static void main(String[] args) {
        Solution solution = new Solution();
        int result = solution.lengthOfLastWord("a");
        System.out.println(result);
    }
    static class Solution {
        public int lengthOfLastWord(String s) {
            int index = s.length() - 1;
            int state = 0;
            int result = 0;
            while (state != 2 && index >= 0) {
                if (state == 0 && s.charAt(index) == ' ') {
                    index--;
                } else if (state == 0 && (Character.isUpperCase(s.charAt(index)) || Character.isLowerCase(s.charAt(index)))) {
                    state = 1;
                    result++;
                    index--;
                } else if (state == 1 && (Character.isUpperCase(s.charAt(index)) || Character.isLowerCase(s.charAt(index)))) {
                    result++;
                    index--;
                } else if (state == 1 && s.charAt(index) == ' ') {
                    state = 2;
                }
            }
            return result;
        }
    }
}
