class Solution {
    public int countSubmatrices(int[][] grid, int k) {
        for(int i = 0; i < grid.length; i++) {
            for(int j = 1; j < grid[0].length; j++) {
                grid[i][j] += grid[i][j-1];
            }
        }
        for(int j = 0; j < grid[0].length; j++) {
            for(int i = 1; i < grid.length; i++) {
                grid[i][j] += grid[i-1][j];
            }
        }
        int ans = 0;
        for(int j = grid[0].length - 1; j >= 0; j--) {
            int r = grid.length - 1;
            int c = j;
            while(r >= 0 && c < grid[0].length) {
                if(grid[r][c] <= k) {
                    ans++;
                }
                r--;
                c++;
            }
        }
        for(int i = grid.length - 2; i >= 0; i--) {
            int r = i;
            int c = 0;
            while(r >= 0 && c < grid[0].length) {
                if(grid[r][c] <= k) {
                    ans++;
                }
                r--;
                c++;
            }
        }
        return ans;
    }
}