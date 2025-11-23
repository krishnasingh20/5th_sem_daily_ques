class Solution {
    public int bestTeamScore(int[] scores, int[] ages) {
        int n = scores.length;
        int[][] arr = new int[n+1][2];
        for(int i = 0; i < n; i++) {
            arr[i+1][0] = ages[i];
            arr[i+1][1] = scores[i];
        }
        Arrays.sort(arr, (a, b)-> a[0]==b[0]?a[1]-b[1]:a[0]-b[0]);
        int[][] dp = new int[n+1][n+1];
        for(int[] d: dp) {
            Arrays.fill(d, -1);
        }
        return bestTeam(arr, 1, 0, dp);
    }
    public int bestTeam(int[][] arr, int i, int prev, int[][] dp) {
        if(i == arr.length) {
            return 0;
        }
        if(dp[i][prev] != -1) {
            return dp[i][prev];
        }
        int inc = 0;
        if(arr[i][0] == arr[prev][0]) {
            inc = arr[i][1] + bestTeam(arr, i+1, i, dp);
        }
        if(arr[i][0] > arr[prev][0] && arr[i][1] >= arr[prev][1]) {
            inc = arr[i][1] + bestTeam(arr, i+1, i, dp);
        } 
        int exc = bestTeam(arr, i+1, prev, dp);
        return dp[i][prev] = Math.max(inc, exc);
    }
}