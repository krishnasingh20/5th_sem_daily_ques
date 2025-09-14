class Solution {
    public int jump(int[] nums) {
        int[] dp = new int[nums.length];
        Arrays.fill(dp, -1);
        return jumpCount(nums, 0, dp);
    }
    public int jumpCount(int[] nums, int i, int[] dp) {
        if(i >= nums.length - 1) {
            return 0;
        }
        if(dp[i] != -1) {
            return dp[i];
        }
        int ans = Integer.MAX_VALUE;
        for(int j = 1; j <= nums[i]; j++) {
            int next = jumpCount(nums, i+j, dp);
            if(next != Integer.MAX_VALUE) {
                ans = Math.min(ans, 1+next);
            }
        }
        dp[i] = ans;
        return ans;
    }
}