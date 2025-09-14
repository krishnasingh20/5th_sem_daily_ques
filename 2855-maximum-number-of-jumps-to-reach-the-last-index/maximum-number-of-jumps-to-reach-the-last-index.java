class Solution {
    public int maximumJumps(int[] nums, int target) {
        long[] dp = new long[nums.length];
        Arrays.fill(dp, -1);
        long ans = maxJump(nums, 0, target, dp);
        return ans == Long.MIN_VALUE?-1:(int)ans;
    }
    public long maxJump(int[] nums, int i, int target, long[] dp) {
        if(i >= nums.length - 1) {
            return 0;
        }
        if(dp[i] != -1) {
            return dp[i];
        }
        long ans = Long.MIN_VALUE;
        for(int j = i + 1; j < nums.length; j++) {
            if((long)nums[j]-nums[i] >= (-1*target) && (long)nums[j]-nums[i] <= target) {
                long next = maxJump(nums, j, target, dp);
                if(next != Long.MIN_VALUE) {
                    ans = Math.max(ans, next+1);
                }
            }
        }
        dp[i] = ans;
        return ans;
    }
}