class Solution {
    public boolean canJump(int[] nums) {
        Boolean[] dp = new Boolean[nums.length];
        return jump(nums, 0, dp);
    }
    public boolean jump(int[] nums, int i, Boolean[] dp) {
        if(i >= nums.length - 1) {
            return true;
        }
        if(dp[i] != null) {
            return dp[i];
        }
        for(int j = 1;  j <= nums[i]; j++) {
            if(jump(nums, i+j, dp)) {
                return dp[i] = true;
            }
        }
        return dp[i] = false;
    }
}