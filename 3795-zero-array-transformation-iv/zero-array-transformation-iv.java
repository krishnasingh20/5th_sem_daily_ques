class Solution {
    Integer[][] dp;
    public int minZeroArray(int[] nums, int[][] queries) {
        int ans = 0;
        int n = nums.length;
        for(int i = 0; i < n; i++) {
            if(nums[i] == 0) {
                continue;
            }
            dp = new Integer[queries.length][nums[i]+1];
            int idx = possible(queries, 0, nums[i], i);
            ans = Math.max(ans, idx);
        }
        return ans==Integer.MAX_VALUE?-1:ans;
    }
    public int possible(int[][] queries, int i, int target, int idx) {
        if(target == 0) {
            return i;
        }
        if(i == queries.length) {
            return Integer.MAX_VALUE;
        }
        if(dp[i][target] != null) {
            return dp[i][target];
        }
        int a = Integer.MAX_VALUE;
        if(queries[i][0] <= idx && idx <= queries[i][1] && target >= queries[i][2]) {
            a = possible(queries, i+1, target-queries[i][2], idx);
        }
        int b = possible(queries, i+1, target, idx);
        return dp[i][target] = Math.min(a, b);
    }
}