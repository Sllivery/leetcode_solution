package daily_problems;

public class BestTimetoBuyandSellStockII122 {
    public static void main(String[] args) {

    }

    static class Solution {
        public int maxProfit(int[] prices) {
            int slow = 0;
            int fast = 1;
            int profitSoFar = 0;
            while (fast < prices.length) {
                if (prices[fast] > prices[slow]) {
                    profitSoFar += prices[fast] - prices[slow];
                }
                slow++;
                fast++;
            }
            return profitSoFar;
        }
    }

}
