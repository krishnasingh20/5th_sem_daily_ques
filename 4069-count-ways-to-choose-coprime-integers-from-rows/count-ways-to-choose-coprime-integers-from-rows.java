class Solution {
    int mod = 1000000007;
    public int countCoprime(int[][] mat) {
        int n = mat.length;
        int m = mat[0].length;
        int ans = 0;
        int[][] dp = new int[n][151];
        for(int[] d: dp) {
            Arrays.fill(d, -1);
        }
        for(int i = 0; i < mat[0].length; i++) {
            ans = (ans + possible(mat, 1, mat[0][i], dp)) % mod;
        }
        return ans;
    }
    public int possible(int[][] mat, int r, int curr, int[][] dp) {
        if(r == mat.length) {
            if(curr == 1) {
                return 1;
            }
            return 0;
        }
        if(dp[r][curr] != -1) {
            return dp[r][curr];
        }
        int ans = 0;
        for(int i = 0; i < mat[0].length; i++) {
            ans = (ans + possible(mat, r+1, gcd(curr, mat[r][i]), dp)) % mod;
        }
        return dp[r][curr] = ans % mod;
    }
    public int gcd(int a, int b) {
        while(b != 0) {
            int temp = b;
            b = a % b;
            a = temp;
        }
        return a;
    }
}