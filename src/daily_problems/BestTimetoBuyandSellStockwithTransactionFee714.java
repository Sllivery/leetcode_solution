package daily_problems;

public class BestTimetoBuyandSellStockwithTransactionFee714 {
    public static void main(String[] args) {

    }

    static class Solution {
        public int maxProfit(int[] prices, int fee) {
            int length = prices.length;
            int[] free = new int[length], hold = new int[length];
            free[0] = 0; //free means sold. we can only convert to free state from holding a stock. Therefore, the transition equation is free[i] = hold[i-1] + prices[i]
            hold[0] = -prices[0];//hold means buy. hold[i] = -price[i] + free[i]
            for (int i = 1; i < length; i++) {
                free[i] = Math.max(free[i - 1], hold[i - 1] + prices[i] - fee);
                hold[i] = Math.max(hold[i - 1], -prices[i] + free[i]);
            }
            //the final state should be sold all the stock
            return free[length - 1];
        }

        public int maxProfitOptimizedVersion(int[] prices, int fee) {
            return 0;
        }
    }
}
