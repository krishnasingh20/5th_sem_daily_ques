class Solution {
    public int minimumArea(int[][] grid) {
        int ans = 0;
        int minR = 10000;
        int maxR = -1;
        int minC = 10000;
        int maxC = -1;
        for(int i = 0; i < grid.length; i++) {
            for(int j = 0; j < grid[0].length; j++) {
                if(grid[i][j] == 1) {
                    minR = Math.min(minR, i);
                    maxR = Math.max(maxR, i);
                    minC = Math.min(minC, j);
                    maxC = Math.max(maxC, j);
                    ans = (maxR - minR + 1)*(maxC - minC + 1);
                }
            }
        }
        return ans;
    }
}