class Solution {
    public int[][] rangeAddQueries(int n, int[][] queries) {
        int[][] ans = new int[n][n];
        for(int i = 0; i < queries.length; i++) {
            int r1 = queries[i][0];
            int c1 = queries[i][1];
            int r2 = queries[i][2]+1;
            int c2 = queries[i][3]+1;
            ans[r1][c1]++;
            if(c2 < n) {
                ans[r1][c2]--;
            }
            if(r2 < n) {
                ans[r2][c1]--;
                if(c2 < n) {
                    ans[r2][c2]++;
                }
            }
        }
        for(int i = 0; i < n; i++) {
            for(int j = 1; j < n; j++) {
                ans[i][j] += ans[i][j-1];
            }
        }
        for(int i = 0; i < n; i++) {
            for(int j = 1; j < n; j++) {
                ans[j][i] += ans[j-1][i];
            }
        }
        return ans;
    }
}