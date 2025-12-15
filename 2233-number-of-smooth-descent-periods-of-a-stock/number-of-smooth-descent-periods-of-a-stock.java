class Solution {
    public long getDescentPeriods(int[] prices) {
        long c = 2;
        long ans = 1;
        for(int i = 1; i < prices.length; i++) {
            if(prices[i-1]-prices[i] == 1) {
                ans += c;
                c++;
            }
            else {
                ans++;
                c = 2;
            }
        }
        return ans;
    }
}