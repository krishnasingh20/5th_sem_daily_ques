class Solution {
    int[][] dp;
    public int maxOperations(int[] nums) {
        dp = new int[nums.length][nums.length];
        for(int[] d: dp) {
            Arrays.fill(d, -1);
        }
        int n = nums.length;
        int max1 = maxOper(nums, 2, n-1, nums[0]+nums[1]);
        for(int[] d: dp) {
            Arrays.fill(d, -1);
        }
        int max2 = maxOper(nums, 0, n-3, nums[n-1]+nums[n-2]);
        for(int [] d: dp) {
            Arrays.fill(d, -1);
        }
        int max3 = maxOper(nums, 1, n-2, nums[0]+nums[n-1]);
        return Math.max(max1, Math.max(max2, max3))+1;
    }
    public int maxOper(int[] nums, int i, int j, int sum) {
        if(i >= j) {
            return 0;
        }
        if(dp[i][j] != -1) {
            return dp[i][j];
        }
        int ans = 0;
        // case1
        if(nums[i] + nums[i+1] == sum) {
            int a = 1 + maxOper(nums, i+2, j, sum);
            ans = Math.max(ans, a);
        }
        // case2
        if(nums[j]+nums[j-1] == sum) {
            int a = 1 + maxOper(nums, i, j-2, sum);
            ans = Math.max(ans, a);
        }
        // case3
        if(nums[i]+nums[j] == sum) {
            int a = 1 + maxOper(nums, i+1, j-1, sum);
            ans = Math.max(ans, a);
        }
        return dp[i][j] = ans;
    }
}