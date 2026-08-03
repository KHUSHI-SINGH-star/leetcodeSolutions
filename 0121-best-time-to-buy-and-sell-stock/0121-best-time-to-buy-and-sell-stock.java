class Solution {
    public int maxProfit(int[] prices) {
        int min = prices[0];
        int profit = 0;
        for (int i = 0; i < prices.length; i++) {
            min = Math.min(min, prices[i]);
            int maxProfit = prices[i] - min;
            profit = Math.max(profit, maxProfit);
        }
        return profit;
    }
}