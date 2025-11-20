class Solution {
    public int lengthOfLongestSubsequence(List<Integer> nums, int target) {
        int[][] dp = new int[nums.size()][target+1];
        for(int[] d: dp) {
            Arrays.fill(d, -1);
        }
        int len = longestSubsequence(nums, target, 0, dp);
        return len <= 0?-1:len;
    }
    public int longestSubsequence(List<Integer> nums, int target, int i, int[][] dp) {
        if(target == 0) {
            return 0;
        }
        if(i == nums.size() || target < 0) {
            return Integer.MIN_VALUE;
        }
        if(dp[i][target] != -1) {
            return dp[i][target];
        }
        int inc = 1 + longestSubsequence(nums, target - nums.get(i), i+1, dp);
        int exc = longestSubsequence(nums, target, i+1, dp);
        return dp[i][target] = Math.max(inc, exc);
    }
}