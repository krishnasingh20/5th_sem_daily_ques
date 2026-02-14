class Solution {
    public long rob(int[] nums, int[] colors) {
        return bottomUp(nums, colors);
    }
    public long bottomUp(int[] nums, int[] colors) {
        int n = nums.length;
        long[][] dp = new long[n+1][2];
        dp[0][1] = nums[0];
        for(int i = n-1; i >= 0; i--) {
            for(int state = 0; state <= 1; state++) {
                long ans = 0;
                if(state == 1 || (i > 0 && colors[i] != colors[i-1])) {
                    ans = nums[i] + dp[i+1][0];
                }
                long skip = dp[i+1][1];
                dp[i][state] = Math.max(skip, ans);
            }
        }
        return dp[0][1];
    }
}