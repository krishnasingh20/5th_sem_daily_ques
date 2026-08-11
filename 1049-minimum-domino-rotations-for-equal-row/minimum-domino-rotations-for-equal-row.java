class Solution {
    public int minDominoRotations(int[] tops, int[] bottoms) {
        int n = tops.length;

        int[][] arr = new int[2][7];
        int[] both = new int[7];

        for(int i = 0; i < n; i++) {
            if(tops[i] == bottoms[i]) {
                both[tops[i]]++;
            }
            else {
                arr[0][tops[i]]++;
                arr[1][bottoms[i]]++;
            }
        }

        int ans = Integer.MAX_VALUE;

        for(int i = 1; i <= 6; i++) {
            if(arr[0][i]+arr[1][i]+both[i] == n) {
                ans = Math.min(ans, Math.min(arr[0][i], arr[1][i]));
            }
        }

        return ans == Integer.MAX_VALUE ? -1 : ans;
    }
}