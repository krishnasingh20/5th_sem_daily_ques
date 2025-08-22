class Solution {
    public int minimumArea(int[][] grid) {
        int n = grid.length;
        int m = grid[0].length;
        int minX = n;
        int maxX = -1;
        int minY = m;
        int maxY = -1;
        for(int i = 0; i < n; i++) {
            for(int j = 0; j < m; j++) {
                if(grid[i][j] == 1) {
                    minX = Math.min(minX, j);
                    maxX =   Math.max(maxX, j);
                    minY = Math.min(minY, i);
                    maxY = Math.max(maxY, i);
                }
            }
        }
        return (maxX - minX + 1)*(maxY - minY + 1);
    }
}