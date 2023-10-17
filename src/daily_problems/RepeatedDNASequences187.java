package daily_problems;

import java.util.*;

public class RepeatedDNASequences187 {
    public static void main(String[] args) {
        String str1 = "AAAAACCCCC";
        String str2 = "AAAAACCCCC";
        HashMap<String, Integer> map = new HashMap<>();
        Integer put = map.put(str1, 1);
        boolean b = map.containsKey(str2);
        System.out.println(b);
        String test = "AAAAAAAAAAAAA";
        Solution solution = new Solution();
        List<String> repeatedDnaSequences = solution.findRepeatedDnaSequences(test);
        for (String repeatedDnaSequence : repeatedDnaSequences) {
            System.out.println(repeatedDnaSequence);
        }
    }

    static class Solution {
        public List<String> findRepeatedDnaSequences(String s) {
            //string pattern
            //create 10 letters long window, and move it to the right, record the reapted string in a hashmap
            int left = 0;
            int right = left + 9;
            HashMap<String, Integer> cache = new HashMap<>();
            HashSet<String> set = new HashSet<>();
            while (right < s.length()) {
                String substr = s.substring(left, right + 1);
                if (cache.containsKey(substr)) {
                    set.add(substr);
                } else {
                    cache.put(substr, 1);
                }
                left++;
                right++;
            }
            return new ArrayList<>(set);
        }
    }
}
