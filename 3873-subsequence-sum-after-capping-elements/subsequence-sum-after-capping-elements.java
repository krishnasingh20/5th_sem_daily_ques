class Solution {
    public boolean[] subsequenceSumAfterCapping(int[] nums, int k) {
        int n = nums.length;
        Arrays.sort(nums);
        boolean[] dp = new boolean[k+1];
        dp[0] = true;
        boolean[] ans = new boolean[n];
        int i = 0;//uncapped elements index upto i
        for(int x = 1; x <= n; x++) {
            while(i < n && nums[i] <= x) {
                for(int k1 = k; k1 >= nums[i]; k1--) {
                    dp[k1] = (dp[k1] | dp[k1-nums[i]]);
                }
                i++;
            }
            int capped = n-i;
            for(int c = 0; c <= capped; c++) {
                int x1 = x*c;
                if(x1 > k) {
                    break;
                }
                if(dp[k-x1]) {
                    ans[x-1] = true;
                    break;
                }
            }
        }
        return ans;
    }
}