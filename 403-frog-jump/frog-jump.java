class Solution {
    public boolean canCross(int[] stones) {
        if(stones[1] - stones[0] != 1) {
            return false;
        }
        Boolean[][] dp = new Boolean[stones.length][stones.length];
        return cross(stones, 1, 1, dp);
    }
    public boolean cross(int[] stones, int i, int k, Boolean[][] dp) {
        if(i == stones.length - 1) {
            return true;
        }
        if(i >= stones.length) {
            return false;
        }
        if(dp[i][k] != null) {
            return dp[i][k];
        }
        for(int idx = i+1; idx < stones.length; idx++) {
            if(stones[idx] - stones[i] == k) {
                if(cross(stones, idx, k, dp)) {
                    return dp[i][k] = true;
                }
            }
            else if(stones[idx] - stones[i] == k-1) {
                if(cross(stones, idx, k-1, dp)) {
                    return dp[i][k] = true;
                }
            }
            else if(stones[idx] - stones[i] == k+1) {
                if(cross(stones, idx, k+1, dp)) {
                    return dp[i][k] = true;
                }
            }
        }
        return dp[i][k] = false;
    }
}