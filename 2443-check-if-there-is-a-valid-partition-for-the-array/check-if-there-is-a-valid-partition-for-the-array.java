class Solution {
    public boolean validPartition(int[] nums) {
        int n = nums.length;
        boolean[] dp = new boolean[n+1];
        dp[0] = true;//before 0th index we can assume that we have valid splits
        dp[1] = false;//1 length subarray is not valid split
        if(nums[1] == nums[0]) {
            dp[2] = true;
        }
        for(int i = 2; i < n; i++) {
            // case-a->when we take two length subarray of all element equal
            boolean a = false;
            if(nums[i] == nums[i-1] && dp[i-1]) {
                a = true;
            }
            // case-b-> when we take split of 3 length subarray with all element are equal
            boolean b = false;
            if(nums[i] == nums[i-1] && nums[i-1] == nums[i-2] && dp[i-2]) {
                b = true;
            }
            // case-c-> when we take 3 length subarray with consecutive increasing element
            boolean c = false;
            if(nums[i]-nums[i-1] == 1 && nums[i-1]-nums[i-2] == 1 && dp[i-2]) {
                c = true;
            }
            dp[i+1] = (a || b || c);//take OR of all three case till ith index for valid split
        }
        return dp[n];
    }
}