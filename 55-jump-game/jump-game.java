class Solution {
    public boolean canJump(int[] nums) {
        // Boolean[] dp = new Boolean[nums.length];
        // return jump(nums, 0, dp);
        return bottomUp(nums);
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
    public boolean bottomUp(int[] nums) {
        boolean[] dp = new boolean[nums.length];
        dp[dp.length - 1] = true;
        for(int i = nums.length - 2; i >= 0; i--) {
            int step = nums[i];
            for(int j = 1; j <= step && i+j < nums.length; j++) {
                if(dp[i+j]) {
                    dp[i] = true;
                    break;
                }
            }
        }
        return dp[0];
    }
}