class Solution {
    public long minIncrease(int[] nums) {
        return bottomUp(nums);
    }

    public long bottomUp(int[] nums) {
        int n = nums.length;

        long[][] dp = new long[n+1][2];

        for(int i = n-2; i >= 1; i--) {
            for(int state = 0; state <= 1; state++) {
                if((n & 1) == 1 && state == 0) {
                    continue;
                }
                long curr = Math.max(0, Math.max(nums[i-1]+1-nums[i], nums[i+1]+1-nums[i])) + dp[i+2][state];
                if(state == 0) {
                    long skip = dp[i+1][1];
                    curr = Math.min(curr, skip);
                }
                dp[i][state] = curr;
            }
        }

        if((n & 1) == 1) {
            return dp[1][1];
        }

        return Math.min(dp[1][0], dp[1][1]);
    }
}