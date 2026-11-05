class Solution {
    public int maxProfit(int[] prices) {
        int maxP = 0;
        int minBuy = prices[0];

        for (int price: prices) {
            maxP = Math.max(maxP, price - minBuy);
            minBuy = Math.min(minBuy, price);
        }
        return maxP;
    }
}
