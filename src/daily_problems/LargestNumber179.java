package daily_problems;

import java.util.Arrays;
import java.util.Comparator;

public class LargestNumber179 {
    public static void main(String[] args) {

    }

    static class Solution {
        class MyComparator implements Comparator<String> {
            @Override
            public int compare(String o1, String o2) {
                String p1 = o1 + o2;
                String p2 = o2 + o1;
                return p2.compareTo(p1);
            }
        }
        public String largestNumber(int[] nums) {
            //I think it can be solved by dp
            //1.base case
            //well, there's more simple way where we just compare very pair lexicographically
            String[] strings = new String[nums.length];
            for (int i = 0; i < nums.length; i++) {
                strings[i] = String.valueOf(nums[i]);
            }
            Arrays.sort(strings, new MyComparator());
            if (strings[0].equals("0")) {
                return "0";
            }
            StringBuilder result = new StringBuilder();
            for (String string : strings) {
                result.append(string);
            }
            return result.toString();
        }
    }
}
