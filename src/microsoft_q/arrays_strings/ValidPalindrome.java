package microsoft_q.arrays_strings;

public class ValidPalindrome {
    public static void main(String[] args) {
        String test = "A man, a plan, a canal: Panama";
        Solution solution = new Solution();
        System.out.println(solution.isPalidrome(test));
    }

    static class Solution{
        public boolean isPalidrome(String s) {
            s = s.toLowerCase();
            char[] chars = new char[s.length()];
            int charsIndex = 0;
            int sIndex = 0;
            for (; sIndex < s.length(); sIndex++) {
                if ((s.charAt(sIndex) >= 'a' && s.charAt(sIndex) <= 'z') || (s.charAt(sIndex) >= '0' && s.charAt(sIndex) <= '9')) {
                    chars[charsIndex] = s.charAt(sIndex);
                    charsIndex++;
                }
            }
            int begin = 0;
            int end = charsIndex - 1;
            while (begin <= charsIndex && end > -1) {
                if (chars[begin] != chars[end]) {
                    return false;
                }
                begin++;
                end--;
            }
            return true;
        }
    }
}
