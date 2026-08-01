class Solution {
    int[][] dp;
    public boolean predictTheWinner(int[] nums) {
        dp = new int[nums.length][nums.length];

        for(int[] d: dp) {
            Arrays.fill(d, -1);
        }

        int scoreA = maxScore(nums, 0, nums.length-1);

        int totalSum = 0;
        for(int num: nums) {
            totalSum += num;
        }

        return scoreA >= totalSum - scoreA;
    }

    public int maxScore(int[] nums, int i, int j) {
        if(i > j) {
            return 0;
        }

        if(i == j) {
            return nums[i];
        }

        if(dp[i][j] != -1) {
            return dp[i][j];
        }

        int a = nums[i] + Math.min(maxScore(nums, i+2, j), maxScore(nums, i+1, j-1));
        int b = nums[j] + Math.min(maxScore(nums, i+1, j-1), maxScore(nums, i, j-2));

        return dp[i][j] = Math.max(a, b);
    }
}