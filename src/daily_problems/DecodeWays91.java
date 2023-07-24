package daily_problems;

import java.util.HashMap;
import java.util.Map;

public class DecodeWays91 {
    public static void main(String[] args) {
        String test = "0";
        Solution solution = new Solution();
        int i = solution.numDecodings(test);
        System.out.println(i);
    }
    static class Solution {
        public int numDecodings(String s) {
            /*
            1.code只有1位和2位
            2.2位的以1或2开头
            3.多少种方法：在搜索空间中搜索。->backtrack的结构
            4.opeartions: index + 1 or index + 2
             */
            Map<Integer, Integer> map = new HashMap<>();
            return helper(map, s, 0);
        }

        public int helper(Map<Integer, Integer> map, String s, int index) {
            if (map.containsKey(index)) {
                return map.get(index);
            }

            //成功的情况，递归是不断缩减所剩未被解码的串，如果串正好结束了，那么成功找到一个
            if (index == s.length() - 1 && s.charAt(index) != '0') {
                return 1;
            }
            //因为还有一种operation是两步的，所以最后可能多一步
            if (index == s.length()) {
                return 1;
            }

            //失败的情况，不能遇到0
            if (s.charAt(index) == '0') {
                return 0;
            }

            int result = helper(map, s, index + 1); //向后推进一个
            if (Integer.parseInt(s.substring(index, index + 2)) <= 26) {
                result += helper(map, s, index + 2); //加上如果向后推荐两个的情况，但是这种需要一个范围，如果后面两个是56，那肯定不行，我们需要特定条件才能执行这个recursive
            }
            map.put(index, result);
            return result;
        }
    }
}
