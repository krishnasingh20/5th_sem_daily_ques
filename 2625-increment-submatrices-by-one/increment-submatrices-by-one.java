class Solution {
    public int[][] rangeAddQueries(int n, int[][] queries) {
        int[][] prefix = new int[n][n];
        for(int[] query: queries) {
            int r1 = query[0];
            int r2 = query[2];
            int c1 = query[1];
            int c2 = query[3];
            for(int i = r1; i <= r2; i++) {
                prefix[i][c1] += 1;
                if(c2+1 < n) {
                    prefix[i][c2+1] -= 1;;
                }
            }
        }
        for(int i = 0; i < n; i++) {
            for(int j = 1; j < n; j++) {
                prefix[i][j] += prefix[i][j-1];
            }
        }
        return prefix;
    }
}