class Solution {
    public int maxSumDivThree(int[] nums) {
        int[][] dp = new int[nums.length][3];
        for(int[] d: dp) {
            Arrays.fill(d, -1);
        }
        return maxSum(nums, 0, 0, dp);
    }
    public int maxSum(int[] nums, int i, int rem, int[][] dp) {
        if(i == nums.length) {
            if(rem == 0) {
                return 0;
            }
            return Integer.MIN_VALUE;
        }
        if(dp[i][rem] != -1) {
            return dp[i][rem];
        }
        int inc = nums[i] + maxSum(nums, i+1, (rem+(nums[i]%3))%3, dp);
        int exc = maxSum(nums, i+1, rem, dp);
        return dp[i][rem] = Math.max(inc, exc);
    }
}