package daily_problems;

import java.util.Collections;
import java.util.HashMap;
import java.util.HashSet;

public class LongestSubstringTwoDistinct159 {
    public static void main(String[] args) {

        //how to remember previous words?
        String test = "ccaabbb";
        Solution solution = new Solution();
        int i = solution.lengthOfLongestSubstringTwoDistinct(test);
        System.out.println(i);
    }

    static class Solution {
        public int lengthOfLongestSubstringTwoDistinct(String s) {
            //eceba
            HashMap<Character, Integer> map = new HashMap<>();
            int result = 0;
            int left = 0;
            int right = 0;
            while (right < s.length()) {
                map.put(s.charAt(right), right);
                //if it's contains two distinct char
                if (map.size() == 3) {
                    //update the left pointer to the right of the samllest index
                    int samllestIndex = Collections.min(map.values());
                    map.remove(s.charAt(samllestIndex));
                    left = samllestIndex + 1;
                }
                if (right - left + 1 > result) {
                    result = right - left + 1;
                }
                right++;
            }
            return result;
        }
    }
}
