class Solution {
    public int maxProfit(int[] prices) {
        int profit = 0;
        int curr = prices[0];
        for(int i = 1; i < prices.length; i++) {
            profit = Math.max(profit, prices[i]-curr);
            curr = Math.min(curr, prices[i]);
        }
        return profit;
    }
}