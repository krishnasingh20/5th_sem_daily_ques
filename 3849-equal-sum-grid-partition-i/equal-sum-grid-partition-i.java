class Solution {
    public boolean canPartitionGrid(int[][] grid) {
        int m = grid.length;
        int n = grid[0].length;
        long totalSum = 0;
        for(int i = 0; i < m; i++) {
            for(int j = 0; j < n; j++) {
                totalSum += grid[i][j];
            }
        }
        long rowSum = 0;
        for(int i = 0; i < m - 1; i++) {
            for(int j = 0; j < n; j++) {
                rowSum += grid[i][j];
            }
            if(totalSum - rowSum == rowSum) {
                return true;
            }
        }
        long colSum = 0;
        for(int j = 0; j < n - 1; j++) {
            for(int i = 0; i < m; i++) {
                colSum += grid[i][j];
            }
            if(totalSum - colSum == colSum) {
                return true;
            }
        }
        return false;
    }
}