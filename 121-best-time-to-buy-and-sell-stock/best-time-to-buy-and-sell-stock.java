class Solution {
    public int maxProfit(int[] prices) {
        int ans = 0;
        int buy = prices[0];
        for(int i = 1; i < prices.length; i++) {
            int profit = prices[i] - buy;
            ans = Math.max(ans, profit);
            if(prices[i] < buy) {
                buy = prices[i];
            }
        }
        return ans;
    }
}