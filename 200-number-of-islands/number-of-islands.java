class Solution {
    public int numIslands(char[][] grid) {
        int ans = 0;
        for(int i = 0; i < grid.length; i++) {
            for(int j = 0; j < grid[0].length; j++) {
                if(grid[i][j] == '1') {
                    ans++;
                    bfs(grid, i, j);
                }
            }
        }
        return ans;
    }
    public void bfs(char[][] grid, int r, int c) {
        if(r < 0 || r >= grid.length || c < 0 || c >= grid[0].length || grid[r][c] == '0') {
            return;
        }
        grid[r][c] = '0';
        bfs(grid, r+1, c);//down
        bfs(grid, r-1, c);//up
        bfs(grid, r, c-1);//left
        bfs(grid, r, c+1);//right
    }
}