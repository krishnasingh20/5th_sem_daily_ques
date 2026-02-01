class Solution {
    Integer[][][][] dp = new Integer[11][2][2][1024];
    public int countSpecialNumbers(int n) {
        return count(String.valueOf(n), 0, 1, 1, 0)-1;//-1 for case when it will count 0 also but needed in range [1, n].
    }
    private int count(String s, int idx, int tight, int lz, int mask) {
        if(idx == s.length()) {
            return 1;
        }
        if(dp[idx][tight][lz][mask] != null) {
            return dp[idx][tight][lz][mask];
        }
        int lb = 0;
        int ub = tight==1?(s.charAt(idx)-'0'):9;
        int ans = 0;
        for(int digit = lb; digit <= ub; digit++) {
            if(lz == 0 && (mask & (1<<digit)) != 0) {
                continue;
            }
            int newTight = (tight==1 && digit==ub)?1:0;
            int newLz = (lz==1 && digit == 0)?1:0;
            int newMask = mask;
            if(lz == 0 && digit == 0) {
                newMask = mask | (1<<digit);
            }
            else if(digit > 0) {
                newMask = mask | (1<<digit);
            }
            ans += count(s, idx+1, newTight, newLz, newMask);
        }
        return dp[idx][tight][lz][mask] = ans;
    }
}