class Solution {
    public int rob(int[] nums) {
        if(nums.length == 1) {
            return nums[0];
        }
        int[] dp1 = new int[nums.length];
        Arrays.fill(dp1, -1);
        int[] dp2 = new int[nums.length];
        Arrays.fill(dp2, -1);
        return Math.max(rob1(nums, 0, nums.length - 1, dp1), rob2(nums, 1, nums.length, dp2));
    }
    public int rob1(int[] nums, int i, int n, int[] dp) {
        if(i >= n) {
            return 0;
        }
        if(dp[i] != -1) {
            return dp[i];
        }
        int a = nums[i] + rob1(nums, i+2, n, dp);
        int b = rob1(nums, i+1, n, dp);
        return dp[i] = Math.max(a, b);
    }
    public int rob2(int[] nums, int i, int n, int[] dp) {
        if(i >= n) {
            return 0;
        }
        if(dp[i] != -1) {
            return dp[i];
        }
        int a = nums[i] + rob2(nums, i+2, n, dp);
        int b = rob2(nums, i+1, n, dp);
        return dp[i] = Math.max(a, b);
    }
}