class Solution {
    static final int[] dx = {0,0,-1,1};
    static final int[] dy = {-1,1,0,0};
    boolean flag;

    public int countSubIslands(int[][] grid1, int[][] grid2) {

        int ans = 0;
        int m = grid1.length;
        int n = grid1[0].length;

        for(int i = 0; i < m; i++) {
            for(int j = 0; j < n; j++) {
                if(grid1[i][j] == 1 && grid2[i][j] == 1) {
                    flag = false;
                    dfs(i, j, grid1, grid2);
                    if(!flag) {
                        ans++;
                    }
                }
            }
        }

        return ans;
    }

    private void dfs(int r, int c, int[][] grid1, int[][] grid2) {
        if(!flag) {
            if(grid1[r][c] == 0) {
                flag = true;
            }
        }

        grid2[r][c] = 0;

        for(int i = 0; i < 4; i++) {
            int newR = r+dx[i];
            int newC = c+dy[i];
            if(newR >= 0 && newR < grid1.length && newC >= 0 && newC < grid1[0].length && grid2[newR][newC] == 1) {
                dfs(newR, newC, grid1, grid2);
            }
        }
    }
}