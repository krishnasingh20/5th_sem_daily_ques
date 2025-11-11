class Solution {
    public boolean canPartition(int[] nums) {
        int totalSum = 0;
        for(int num: nums) {
            totalSum += num;
        }
        if((totalSum & 1) == 1) {
            return false;
        }
        int target = totalSum / 2;
        Boolean[][] dp = new Boolean[nums.length][target+1];
        return possible(nums, 0, target, dp);
    }
    public boolean possible(int[] nums, int i, int target, Boolean[][] dp) {
        if(target == 0) {
            return true;
        }
        if(i == nums.length || target < 0) {
            return false;
        }
        if(dp[i][target] != null) {
            return dp[i][target];
        }
        boolean pick = possible(nums, i+1, target - nums[i], dp);
        boolean notPick = possible(nums, i+1, target, dp);
        return dp[i][target] = (pick || notPick);
    }
}