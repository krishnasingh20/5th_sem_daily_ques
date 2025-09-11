class Solution {
    public int combinationSum4(int[] nums, int target) {
        int[] dp = new int[target+1];
        Arrays.fill(dp, -1);
        return combSum(nums, target, 0, dp);
    }
    public int combSum(int[] nums, int target, int currSum, int[] dp) {
        if(currSum == target) {
            return 1;
        }
        if(dp[currSum] != -1) {
            return dp[currSum];
        }
        int count = 0;
        for(int i = 0; i < nums.length; i++) {
            if(nums[i]+currSum <= target) {
                count += combSum(nums, target, currSum+ nums[i], dp);
            }
        }
        return dp[currSum] = count;
    }
}