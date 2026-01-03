class Solution {
    int n;
    Integer[][] dp;
    public int maxValue(int[][] events, int k) {
        n = events.length;
        dp = new Integer[n][k+1];
        Arrays.sort(events, (a,b)->a[0]-b[0]);
        return maxSum(events, 0, k);
    }
    public int maxSum(int[][] events, int i, int k) {
        if(i == n || k == 0) {
            return 0;
        }
        if(dp[i][k] != null) {
            return dp[i][k];
        }
        int ans = 0;
        int idx = binarySearch(events, i+1, n-1, events[i][1]);
        if(idx != -1) {
            ans = maxSum(events, idx, k-1);
        }
        int notAttend = maxSum(events, i+1, k);
        return dp[i][k] = Math.max(notAttend, ans+events[i][2]);
    }
    public int binarySearch(int[][] events, int low, int high, int end) {
        int idx = -1;
        while(low <= high) {
            int mid = low + (high-low)/2;
            if(events[mid][0] > end) {
                idx = mid;
                high = mid - 1;
            }
            else {
                low = mid + 1;
            }
        }
        return idx;
    }
}