package daily_problems;

import java.util.Arrays;

public class ReverseWordsinaStringII186 {
    public static void main(String[] args) {
        char[] test = {'a'};
        Solution solution = new Solution();
        solution.reverseWords(test);
        System.out.println(Arrays.toString(test));
    }

    static class Solution {
        public void reverseWords(char[] s) {

        }
        public void reverseWordsWith2N(char[] s) {
            //make room?
            //smart way: reverse the whole string, then reverse each words

            //reverse the string
            int left = 0;
            int right = s.length - 1;
            while (left < right) {
                char temp = s[left];
                s[left] = s[right];
                s[right] = temp;
                left++;
                right--;
            }

            //reverse each words
            int nextBegin = 0;
            int beginOfWord = nextBegin;
            int endOfWord = beginOfWord;

            while (endOfWord < s.length) {
                if (endOfWord != s.length - 1 && s[endOfWord + 1] != ' ') {
                    endOfWord++;
                    continue;
                }
                nextBegin = endOfWord + 2;
                while (beginOfWord < endOfWord) {
                    char temp = s[beginOfWord];
                    s[beginOfWord] = s[endOfWord];
                    s[endOfWord] = temp;
                    beginOfWord++;
                    endOfWord--;
                }

                beginOfWord = nextBegin;
                endOfWord = beginOfWord;
            }
        }
    }
}
