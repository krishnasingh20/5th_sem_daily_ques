class Solution {
    public int maxAreaOfIsland(int[][] grid) {
        int ans = 0;
        for(int i = 0; i < grid.length; i++) {
            for(int j = 0; j < grid[0].length; j++) {
                if(grid[i][j] == 1) {
                    ans = Math.max(ans, bfs(grid, i, j));
                }
            }
        }
        return ans;
    }
    public int bfs(int[][] grid, int r, int c) {
        if(r < 0 || r >= grid.length || c < 0 || c >= grid[0].length || grid[r][c] == 0) {
            return 0;
        }
        int count = 0;
        grid[r][c] = 0;
        count += bfs(grid, r+1, c);//down
        count += bfs(grid, r-1, c);//up
        count += bfs(grid, r, c-1);//left
        count += bfs(grid, r, c+1);//right
        return count + 1;
    }
}