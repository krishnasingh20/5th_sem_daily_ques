class Solution {
    public int countDigitOne(int n) {
        return solve(n);
    }
    static Integer[][][] dp;
    public static int solve(int n) {
        String s = String.valueOf(n);
        dp = new Integer[11][2][10];
        return countDigitOne(s, 0, 1, 0);
    }
    private static int countDigitOne(String s, int idx, int tight, int cnt_1) {
        if(idx == s.length()) {
            return cnt_1;
        }
        if(dp[idx][tight][cnt_1] != null) {
            return dp[idx][tight][cnt_1];
        }
        int lowerBound = 0;
        int upperBound = (tight == 1)?(s.charAt(idx)-'0'):9;
        int ans = 0;
        for(int digit = lowerBound; digit <= upperBound; digit++) {
            int newTight = (tight == 1 && digit == upperBound)?1:0;
            int newCnt_1 = digit==1?cnt_1+1:cnt_1;
            ans += countDigitOne(s, idx+1, newTight, newCnt_1);
        }
        return dp[idx][tight][cnt_1] = ans;
    }
}