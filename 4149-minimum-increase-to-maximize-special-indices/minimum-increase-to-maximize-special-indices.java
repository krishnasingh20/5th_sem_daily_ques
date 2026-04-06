class Solution {
    public long minIncrease(int[] nums) {

        int n = nums.length;
        int state = (n & 1)==1?1:0;

        dp = new Long[n][2];

        return minInc(nums, 1, state);
    }

    Long[][] dp;

    public long minInc(int[] nums, int i, int state) {
        if(i >= nums.length-1) {
            return 0;
        }

        if(dp[i][state] != null) {
            return dp[i][state];
        }

        long ans = Math.max(0, Math.max(nums[i-1]+1-nums[i], nums[i+1]+1-nums[i])) + minInc(nums, i+2, state);

        if(state == 0) {
            long skip = minInc(nums, i+1, 1);
            ans = Math.min(ans, skip);
        }

        return dp[i][state] = ans;
    }
}