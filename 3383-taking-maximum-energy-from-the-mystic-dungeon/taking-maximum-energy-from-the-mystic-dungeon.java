class Solution {
    public int maximumEnergy(int[] energy, int k) {
        int ans = Integer.MIN_VALUE;
        int[] dp = new int[energy.length];
        Arrays.fill(dp, -1000000000);
        for(int i = 0; i < energy.length; i++) {
            ans = Math.max(ans, energy[i] + maxEnergy(energy, i+k, k, dp));
        }
        return ans;
    }
    public int maxEnergy(int[] energy, int i, int k, int[] dp) {
        if(i >= energy.length - 1) {
            if(i == energy.length - 1) {
                return energy[i];
            }
            return 0;
        }
        if(dp[i] != -1000000000) {
            return dp[i];
        }
        return dp[i] = energy[i]+maxEnergy(energy, i+k, k, dp);
    }
}