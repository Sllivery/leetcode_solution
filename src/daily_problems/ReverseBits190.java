package daily_problems;

import java.util.ArrayList;
import java.util.Collections;

public class ReverseBits190 {
    public static void main(String[] args) {
        Solution solution = new Solution();
        int i = solution.reverseBits(20230);
        System.out.println(i);
    }

    static public class Solution {
        // you need treat n as an unsigned value
        public int reverseBits(int n) {
            //n is decimal, convert it to binary string
            ArrayList<String> list = new ArrayList<>();
            for (int i = 31; i >= 0; i--) {
                int k = n >> i;
                if ((k & 1) > 0) list.add("1");
                else list.add("0");
            }
            //parse the reversed string
            StringBuilder builder = new StringBuilder();
            for (int i = list.size() - 1; i >= 0; i--) {
                builder.append(list.get(i));
            }
            return Integer.parseInt(builder.toString(), 2);
        }
    }
}
