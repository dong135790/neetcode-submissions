class Solution {
    public int maxProfit(int[] prices) {
        int buyPrice = prices[0];
        int profit = 0;

        for (int price: prices) {
            if (price < buyPrice) {
                buyPrice = price;
            }
            profit = Math.max(profit, price - buyPrice);
        }
        return profit;
    }
}
