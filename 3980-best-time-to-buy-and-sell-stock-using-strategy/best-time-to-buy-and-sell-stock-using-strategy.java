class Solution {
    public long maxProfit(int[] prices, int[] strategy, int k) {
        int n = prices.length;
        long[] prefix1 = new long[n+1];
        long[] prefix2 = new long[n+1];
        for(int i = 0; i < n; i++) {
            prefix1[i+1] = ((long)prices[i] * strategy[i]) + prefix1[i];
            prefix2[i+1] = prices[i] + prefix2[i];
        }
        long ans = prefix1[n];
        long sum = prefix1[n];
        int half = k / 2;
        for(int i = 0; i <= n - k; i++) {
            int end = i+k;
            int mid = i+half;
            long curr = prefix2[end] - prefix2[mid];
            long temp =  prefix1[end] - prefix1[i];
            ans = Math.max(ans, sum - temp + curr);
        }
        return ans;
    }
}