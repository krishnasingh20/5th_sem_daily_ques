class Solution {
    public int rob(int[] nums) {
        int[] dp = new int[nums.length];
        Arrays.fill(dp,-1);
        return robber(nums, 0, dp);
    }
    public int robber(int[] arr, int i, int[] dp) {
        if(i >= arr.length) {
            return 0;
        }
        if(dp[i] != -1) {
            return dp[i];
        }
        int robb = arr[i] + robber(arr, i+2, dp);
        int dont_rob = robber(arr, i+1, dp);
        return dp[i] = Math.max(robb, dont_rob);
    }
}