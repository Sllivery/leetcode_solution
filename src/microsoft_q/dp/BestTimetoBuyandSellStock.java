package microsoft_q.dp;

/***
 * You are given an array prices where prices[i] is the price of a given stock on the ith day.
 *
 * You want to maximize your profit by choosing a single day to buy one stock and choosing a different day in the future to sell that stock.
 *
 * Return the maximum profit you can achieve from this transaction. If you cannot achieve any profit, return 0.
 */
public class BestTimetoBuyandSellStock {
    public static void main(String[] args) {
        int[] a = {7, 1, 5, 3, 6, 4};
        Solution solution = new Solution();
        int result = solution.maxProfit(a);
        System.out.println(result);
    }
}

class Solution{
    public int maxProfit(int[] prices) {
        int min = Integer.MAX_VALUE;
        int result = 0;
        for (int price : prices) {
            if (price < min){
                min = price;
            } else if (price - min > result) {
                result = price - min;
            }
        }
        if (result > 0) {
            return result;
        }
        return 0;
    }
}
