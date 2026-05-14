class Solution {
    Integer[] dp;
    public int maximumJumps(int[] nums, int target) {
        dp = new Integer[nums.length];
        int ans = maxJump(nums, 0, target);
        return ans < 0 ? -1 : ans;
    }

    private int maxJump(int[] nums, int i, int target) {
        if(i == nums.length - 1) {
            return 0;
        }

        if(dp[i] != null) {
            return dp[i];
        }

        int ans = Integer.MIN_VALUE/100;

        for(int j = i+1; j < nums.length; j++) {
            if(nums[j] - nums[i] >= -target && nums[j] - nums[i] <= target) {
                int curr = 1 + maxJump(nums, j, target);
                ans = Math.max(ans, curr);
            }
        }

        return dp[i] = ans;
    }
}