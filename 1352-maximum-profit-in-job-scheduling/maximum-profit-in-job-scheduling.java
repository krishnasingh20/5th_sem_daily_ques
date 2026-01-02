class Solution {
    int[][] arr;
    int n;
    Integer[] dp;
    public int jobScheduling(int[] startTime, int[] endTime, int[] profit) {
        n = startTime.length;
        arr = new int[n][3];
        dp = new Integer[n];
        for(int i = 0; i < n; i++) {
            arr[i][0] = startTime[i];
            arr[i][1] = endTime[i];
            arr[i][2] = profit[i];
        }
        Arrays.sort(arr, (a, b)->a[0]-b[0]);
        return schedule(0);
    }
    public int schedule(int i) {
        if(i == n) {
            return 0;
        }
        if(dp[i] != null) {
            return dp[i];
        }
        int low = i+1;
        int high = n-1;
        int idx = -1;
        int ans = 0;
        while(low <= high) {
            int mid = low + (high-low)/2;
            if(arr[mid][0] >= arr[i][1]) {
                idx = mid;
                high = mid - 1;
            }
            else {
                low = mid + 1;
            }
        }
        if(idx != -1) {
            ans = schedule(idx);
        }
        int b = schedule(i+1);
        return dp[i] = Math.max(ans+arr[i][2], b);
    }
}