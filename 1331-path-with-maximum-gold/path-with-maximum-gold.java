class Solution {
    public int getMaximumGold(int[][] grid) {
        int ans = Integer.MIN_VALUE;
        for(int i = 0; i < grid.length; i++) {
            for(int j = 0; j < grid[0].length; j++) {
                if(grid[i][j] > 0) {
                    ans = Math.max(ans, getGold(grid, i, j));
                }
            }
        }
        return ans == Integer.MIN_VALUE?0:ans;
    }
    public int getGold(int[][] grid, int r, int c) {
        if(r < 0 || r >= grid.length || c < 0 || c >= grid[0].length || grid[r][c] == 0) {
            return 0;
        }
        int val = grid[r][c];
        grid[r][c] = 0;
        int down = getGold(grid, r+1, c);
        int up = getGold(grid, r-1, c);
        int left = getGold(grid, r, c-1);
        int right = getGold(grid, r, c+1);
        grid[r][c] = val;
        return Math.max(Math.max(down , up), Math.max(left, right)) + val;
    }
}