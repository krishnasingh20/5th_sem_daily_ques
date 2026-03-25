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

        //horizontal cut
        long currSum = 0;
        for(int i = 0; i < m-1; i++) {

            for(int j = 0; j < n; j++) {
                currSum += grid[i][j];
            }

            if(2*currSum == totalSum) {
                return true;
            }
        }

        //vertical cur
        currSum = 0;
        for(int j = 0; j < n-1; j++) {

            for(int i = 0; i < m; i++) {
                currSum += grid[i][j];
            }
            
            if(2*currSum == totalSum) {
                return true;
            }
        }

        return false;
    }
}