class Solution {
    public int maxProfit(int[] prices) {
        int left = 0;
        int right = left + 1;
        int profit = 0;
        while (left < prices.length - 1) {
            while ( right < prices.length && prices[left] < prices[right]) {
                profit = Math.max(profit, prices[right] - prices[left]);
                right++;
            }
            System.out.println(profit);
            left++;
            right = left + 1;
        }
        return profit;
    }
}
