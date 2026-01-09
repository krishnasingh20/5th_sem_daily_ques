class Solution {
    int n;
    Integer[][][] dp;
    public int maximumLength(int[] nums) {
        n = nums.length;
        for(int i = 0; i < n; i++) {
            nums[i] %= 2;
        }
        dp = new Integer[n][4][2];
        return maxLen(nums, 0, 0, -2)+1;
    }
    public int maxLen(int[] nums, int i, int rem, int val) {
        if(i == n) {
            return 0;
        }
        if(dp[i][val+2][rem] != null) {
            return dp[i][val+2][rem];
        }
        int ans = 0;
        if(val == -2) {
            ans = maxLen(nums, i+1, nums[i], -1);
        }
        else if(val == -1) {
            ans = 1 + maxLen(nums, i+1, (rem+nums[i])%2, nums[i]);
        }
        else {
            if((val+nums[i])%2 == rem) {
                ans = 1 + maxLen(nums, i+1, (val+nums[i])%2, nums[i]);
            }
        }
        int skip = maxLen(nums, i+1, rem, val);
        ans = Math.max(ans, skip);
        return dp[i][val+2][rem] = ans;
    }
}