class Solution {
    public int maxProfit(int[] prices) {
        int current = prices[0];
        int profit = 0;
        for (int i = 1; i < prices.length; i++) {
            // Next price will make me a profit
            if (current < prices[i]) {
                profit += prices[i] - current;
                current = prices[i];
            }
            // Next price is lower than my current holding
            if (current > prices[i]) {
                current = prices[i];
            }
        }
        return profit;
    }
}