package daily_problems;

import java.util.HashMap;
import java.util.HashSet;

public class ClimbingStairs70 {
    public static void main(String[] args) {
        Solution solution = new Solution();
        int i = solution.climbStairs(2);
        System.out.println(i);
    }

    static class Solution {
        public int climbStairs(int n) {
            HashMap<Integer, Integer> map = new HashMap<>();
            return helper(n, map);
        }

        private int helper(int n, HashMap<Integer, Integer> map) {
            if (map.containsKey(n)) {
                return map.get(n);
            }
            if (n == 0) {
                return 1;
            }
            if (n < 0) {
                return 0;
            }
            int result = helper(n - 1, map) + helper(n - 2, map);
            map.put(n, result);
            return result;
        }
    }
}
