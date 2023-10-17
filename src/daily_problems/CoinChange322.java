package daily_problems;

import java.util.Arrays;
import java.util.HashMap;

public class CoinChange322 {
    public static void main(String[] args) {
        int[] array = {1};
        int amount = 0;
        Solution solution = new Solution();
        int i = solution.coinChange(array, amount);
        System.out.println(i);
    }

    static class Solution {
        private int[] memo;
        public int coinChange(int[] coins, int amount) {
            memo = new int[amount + 1];
            Arrays.fill(memo, -767);
            return dp(coins, amount);
        }

        //用最少的硬币凑出amount，f(n) = min(f(n - 1)) + 1
        private int dp(int[] coins, int amount) {
            //base case
            if (amount == 0) return 0;
            if (amount < 0) return -1;
            //get result from memo
            if (memo[amount] != -767) {
                return memo[amount];
            }
            //legal operations
            int result = Integer.MAX_VALUE;
            for (int coin : coins) {
                int temp = dp(coins, amount - coin);
                if (temp == -1) {
                    continue;
                }
                if (temp < result) {
                    result = temp;
                }
            }
            //record and return result
            memo[amount] = result == Integer.MAX_VALUE ? -1 : result + 1;
            return memo[amount];
        }
    }
}
