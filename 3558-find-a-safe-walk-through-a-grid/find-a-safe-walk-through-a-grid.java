class Solution {
    static int[] dx = {0,0,-1,1};
    static int[] dy = {1,-1,0,0};
    int m;
    int n;
    Boolean[][][] dp;
    public boolean findSafeWalk(List<List<Integer>> grid, int health) {
        m = grid.size();
        n = grid.get(0).size();
        dp = new Boolean[m][n][health+1];
        return dfs(grid, 0, 0, health);
    }
    public boolean dfs(List<List<Integer>> grid, int r, int c, int health) {
        if(r == m-1 && c == n-1) {
            if(grid.get(r).get(c) == 1) {
                health--;
            }

            if(health >= 1) {
                return true;
            }
            return false;
        }
        if(health <= 0) {
            return false;
        }
        if(dp[r][c][health] != null) {
            return dp[r][c][health];
        }
        int val = grid.get(r).get(c);
        grid.get(r).set(c, -1);
        for(int i = 0; i < 4; i++) {
            int nx = r+dx[i];
            int ny = c+dy[i];
            if(nx >= 0 && ny >= 0 && nx < m && ny < n && grid.get(nx).get(ny) != -1) {
                boolean flag = dfs(grid, nx, ny, health-val);
                if(flag) {
                    return dp[r][c][health] = true;
                }
            }
        }
        grid.get(r).set(c, val);
        return dp[r][c][health] = false;
    }
}