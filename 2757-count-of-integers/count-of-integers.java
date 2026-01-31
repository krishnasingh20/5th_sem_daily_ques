import java.math.BigInteger;
class Solution {
    Long[][][] dp;
    static int mod = 1000000007;
    public int count(String num1, String num2, int minSum, int maxSum) {
        BigInteger a = new BigInteger(num1);
        BigInteger b = BigInteger.valueOf(1);
        num1 = (a.subtract(b)).toString();
        dp = new Long[23][2][maxSum+1];
        long ans_r = countGood(num2, 0, 1, 0, minSum, maxSum);
        dp = new Long[23][2][maxSum+1];
        long ans_l = countGood(num1, 0, 1, 0, minSum, maxSum);
        return (int)((ans_r - ans_l + mod)%mod);
    }
    private long countGood(String s, int idx, int tight, int sum, int minSum, int maxSum) {
        if(idx == s.length()) {
            if(sum >= minSum && sum <= maxSum) {
                return 1;
            }
            return 0;
        }
        if(sum > maxSum) {
            return 0;
        }
        if(dp[idx][tight][sum] != null) {
            return dp[idx][tight][sum];
        }
        int lb = 0;
        int ub = (tight == 1)?(s.charAt(idx)-'0'):9;
        long ans = 0;
        for(int digit = lb; digit <= ub; digit++) {
            int newTight = (tight == 1 && digit == ub)?1:0;
            ans += countGood(s, idx+1, newTight, sum+digit, minSum, maxSum) % mod;
        }
        return dp[idx][tight][sum] = ans % mod;
    }
}