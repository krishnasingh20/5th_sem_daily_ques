class Solution {
    Integer[][][][][][] dp;
    public int numberOfBeautifulIntegers(int low, int high, int k) {
        return solve(low, high, k);
    }
    public int solve(int low, int high, int k) {
        String l = String.valueOf(low-1);
        String r = String.valueOf(high);
        dp = new Integer[10][2][10][10][k][2];
        int ans_r = count(r, 0, 1, 0, 0, 0, 1, k);
        dp = new Integer[10][2][10][10][k][2];
        int ans_l = count(l, 0, 1, 0, 0, 0, 1, k);
        return ans_r - ans_l;
    }
    private int count(String s, int idx, int tight, int even, int odd, int rem, int lz, int k) {
        if(idx == s.length()) {
            if(even == odd && rem == 0) {
                return 1;
            }
            return 0;
        }
        if(dp[idx][tight][even][odd][rem][lz] != null) {
            return dp[idx][tight][even][odd][rem][lz];
        }
        int lb = 0;
        int ub = (tight==1)?(s.charAt(idx)-'0'):9;
        int res = 0;
        for(int digit = lb; digit <= ub; digit++) {
            int newRem = (rem*10 + digit) % k;
            int newTight = (tight == 1 && digit == ub)?1:0;
            int newLz = (lz == 1 && digit == 0)?1:0;
            int newEven = even;
            int newOdd = odd;
            if((digit & 1) == 1) {
                newOdd++;
            }
            else if((digit == 0 && lz == 0) || digit > 0) {
                newEven++;
            }
            res += count(s, idx+1, newTight, newEven, newOdd, newRem, newLz, k);
        }
        return dp[idx][tight][even][odd][rem][lz] = res;
    }
}