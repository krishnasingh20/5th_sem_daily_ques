class Solution {
    public boolean validPartition(int[] nums) {
        int n = nums.length;
        boolean[] dp = new boolean[n+1];
        dp[0] = true;
        dp[1] = false;
        for(int i = 1; i < n; i++) {
            //case-1->for 2 equal element
            boolean a = false;
            if(nums[i] == nums[i-1] && dp[i-1]) {
                a = true;
            }
            boolean b = false;
            boolean c = false;
            if(i >= 2) {
                //case-2->for 3 equal element
                if(nums[i] == nums[i-1] && nums[i-1] == nums[i-2] && dp[i-2]) {
                    b = true;
                }
                // case-3->for 3 consecutive increasing element
                if(nums[i]-nums[i-1] == 1 && nums[i-1] - nums[i-2] == 1 && dp[i-2]) {
                    c = true;
                } 
            }
            dp[i+1] = (a || b || c);
        }
        return dp[n];
    }
}