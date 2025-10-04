class Solution {
    public int rob(int[] nums) {
        // int[] dp = new int[nums.length];
        // Arrays.fill(dp, -1);
        // return topDown(nums, 0, dp);
        return bottomUp(nums);
    }
    public int topDown(int[] nums, int i, int[] dp) {
        if(i >= nums.length) {
            return 0;
        }
        if(dp[i] != -1) {
            return dp[i];
        }
        int a = nums[i] + topDown(nums, i+2, dp);
        int b = topDown(nums, i+1, dp);
        return dp[i] = Math.max(a, b);
    }
    public int bottomUp(int[] nums) {
        if(nums.length == 1) {
            return nums[0];
        }
        int[] dp = new int[nums.length];
        dp[nums.length - 1] = nums[nums.length - 1];
        dp[nums.length - 2] = Math.max(nums[nums.length - 1], nums[nums.length - 2]);
        for(int i = nums.length - 3; i >= 0; i--) {
            dp[i] = Math.max(nums[i]+dp[i+2], dp[i+1]);
        }
        return dp[0];
    }
}