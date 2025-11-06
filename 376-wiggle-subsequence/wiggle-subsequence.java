class Solution {
    public int wiggleMaxLength(int[] nums) {
        int[][][] dp = new int[nums.length][3][nums.length+1];
        for(int[][] d: dp) {
            for(int[] a: d) {
                Arrays.fill(a, -1);
            }
        }
        return wiggle(nums, 0, 0, -1, dp);
    }
    public int wiggle(int[] arr, int i, int state, int prev, int[][][] dp) {
        if(i == arr.length) {
            return 0;
        }
        if(dp[i][state][prev+1] != -1) {
            return dp[i][state][prev+1];
        }
        int ans = 0;
        // pick
        if(prev != -1) {
            if(arr[prev] - arr[i] > 0) {
                if(state == 0 || state == 1) {
                    int a = 1 + wiggle(arr, i+1, 2, i, dp);
                    ans = Math.max(ans, a);
                }
            }
            else if(arr[prev] - arr[i] < 0) {
                if(state == 0 || state == 2) {
                    int a = 1 + wiggle(arr, i+1, 1, i, dp);
                    ans = Math.max(ans, a);
                }
            }
        }
        else {
            int b = 1 + wiggle(arr, i+1, 0, i, dp);
            ans = Math.max(ans, b);
        }
        // no pick
        int c = wiggle(arr, i+1, state, prev, dp);
        ans = Math.max(ans, c);
        return dp[i][state][prev+1] = ans;
    }
}