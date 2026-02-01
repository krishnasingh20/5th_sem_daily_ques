class Solution {
    Integer[][][] dp = new Integer[10][2][9];
    public int countDigitOne(int n) {
        return count(String.valueOf(n), 0, 1, 0);
    }
    private int count(String s, int i, int t, int cnt_1) {
        if(i == s.length()) {
            return cnt_1;
        }
        if(dp[i][t][cnt_1] != null) {
            return dp[i][t][cnt_1];
        }
        int lb = 0;
        int ub = t==1?(s.charAt(i)-'0'):9;
        int ans = 0;
        for(int digit = lb; digit <= ub; digit++) {
            int newT = (t==1 && digit==ub)?1:0;
            int newCnt_1 = cnt_1 + ((digit==1)?1:0);
            ans += count(s, i+1, newT, newCnt_1);
        }
        return dp[i][t][cnt_1] = ans;
    }
}