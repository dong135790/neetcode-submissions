class Solution {
    public int maxProfit(int[] prices) {
        int left = 0, right = 0;
        int max = 0;

        while (right < prices.length) {
            int profit = prices[right] - prices[left];
            max = Math.max(max, profit);
            if (prices[right] < prices[left]) {
                left = right;
            }
            right++;
        }
        return max;
    }
}
