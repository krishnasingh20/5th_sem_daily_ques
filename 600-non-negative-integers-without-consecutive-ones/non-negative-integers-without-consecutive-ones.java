class Solution {
    public int findIntegers(int n) {
        String s = Integer.toBinaryString(n);
        dp = new Integer[s.length()][2][2];
        return find(s, 0, 1, 0);
    }
    Integer[][][] dp;
    private int find(String s, int idx, int tight, int prev) {
        if(idx == s.length()) {
            return 1;
        }
        if(tight == 0 && dp[idx][tight][prev] != null) {
            return dp[idx][tight][prev];
        }
        int lb = 0;
        int ub = (tight==1)?(s.charAt(idx)-'0'):1;
        int ans = 0;
        for(int bit = lb; bit <= ub; bit++) {
            if(prev == 1 && bit == 1) {
                continue;
            }
            int newTight = (tight==1 && bit == ub)?1:0;
            ans += find(s, idx+1, newTight, bit);
        }
        if(tight == 0) {
            dp[idx][tight][prev] = ans;
        }
        return ans;
    }
}