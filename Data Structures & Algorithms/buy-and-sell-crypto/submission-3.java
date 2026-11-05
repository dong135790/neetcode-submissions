class Solution {
    public int maxProfit(int[] prices) {
        int max = 0;
        int left = 0;
        int right = 0;

        while (right < prices.length) {
            if (prices[right] < prices[left]) {
                left = right;
            } else {
                max = Math.max(max, prices[right] - prices[left]);
            }
            right++;
        }
        return max;
    }
}
