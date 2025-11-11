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
        boolean[] dp = new boolean[target+1];
        dp[0] = true;//base case
        for(int num: nums) {
            for(int i = target; i >= num; i--) {
                if(dp[i-num] || dp[i]) {
                    dp[i] = true;
                }
            }
        }
        return dp[target];
    }
}