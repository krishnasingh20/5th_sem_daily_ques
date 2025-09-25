class Solution {
    public int minimumTotal(List<List<Integer>> triangle) {
        int n = triangle.get(triangle.size()-1).size();
        int[][] dp = new int[n][n];
        for(int[] d: dp) {
            Arrays.fill(d, 1000000000);
        }
        return minTotal(triangle, 0, 0, dp);
    }
    public int minTotal(List<List<Integer>> ll, int i, int j, int[][] dp) {
        if(i == ll.size()) {
            return 0;
        }
        if(dp[i][j] != 1000000000) {
            return dp[i][j];
        }
        int a = ll.get(i).get(j) + minTotal(ll, i+1, j, dp);
        int b = Integer.MAX_VALUE;
        if(j+1 < ll.get(i).size()) {
            b = ll.get(i).get(j+1) + minTotal(ll, i+1, j+1, dp);
        }
        return dp[i][j] = Math.min(a, b);
    }
}