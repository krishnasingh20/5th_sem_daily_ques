class Solution {
    public int numMagicSquaresInside(int[][] grid) {
        int r = grid.length;
        int c = grid[0].length;
        if(r < 3 || c < 3) {
            return 0;
        }
        int ans = 0;
        for(int i = 0; i <= r-3; i++) {
            for(int j = 0; j <= c-3; j++) {
                if(valid(grid, i, j)) {
                    ans++;
                }
            }
        }
        return ans;
    }
    public boolean valid(int[][] grid, int r, int c) {
        boolean[] visit = new boolean[10];
        for(int i = r; i < r+3; i++) {
            for(int j = c; j < c+3; j++) {
                if(grid[i][j] == 0 || grid[i][j] > 9) {
                    return false;
                }
                if(visit[grid[i][j]]) {
                    return false;
                }
                visit[grid[i][j]] = true;
            }
        }
        for(int i = 1; i < 10; i++) {
            if(!visit[i]) {
                return false;
            }
        }
        int d1 = grid[r][c]+grid[r+1][c+1]+grid[r+2][c+2];
        int d2 = grid[r][c+2]+grid[r+1][c+1]+grid[r+2][c];
        int r1 = grid[r][c]+grid[r][c+1]+grid[r][c+2];
        int r2 = grid[r+1][c]+grid[r+1][c+1]+grid[r+1][c+2];
        int r3 = grid[r+2][c]+grid[r+2][c+1]+grid[r+2][c+2];
        int c1 = grid[r][c]+grid[r+1][c]+grid[r+2][c];
        int c2 = grid[r][c+1]+grid[r+1][c+1]+grid[r+2][c+1];
        int c3 = grid[r][c+2]+grid[r+1][c+2]+grid[r+2][c+2];
        return (d1 == d2 && d2 == r1 && r1 == r2 && r2 == r3 && r3 == c1 && c1 == c2 && c2 == c3);
    }
}