class Solution {
    public String stoneGameIII(int[] stoneValue) {

        int stoneA = bottomUp(stoneValue);

        int totalSum = 0;
        for(int s: stoneValue) {
            totalSum += s;
        }

        if(stoneA == totalSum - stoneA) {
            return "Tie";
        }

        return stoneA > (totalSum - stoneA) ? "Alice" : "Bob";
    }

    public int bottomUp(int[] stone) {
        int n = stone.length;
        int[] dp = new int[7];

        for(int i = n-1; i >= 0; i--) {
            int a = stone[i] + Math.min((i+2 < n ? dp[2] : 0), Math.min((i+3 < n ? dp[3] : 0), (i+4 < n ? dp[4] : 0)));

            int b = Integer.MIN_VALUE;
            int c = Integer.MIN_VALUE;

            if(i+1 < n) {
                b = stone[i] + stone[i+1] + Math.min((i+3 < n ? dp[3] : 0), Math.min((i+4 < n ? dp[4] : 0), (i+5 < n ? dp[5] : 0)));
            }

            if(i+2 < n) {
                c = stone[i] + stone[i+1] + stone[i+2] + Math.min((i+4 < n ? dp[4] : 0), Math.min((i+5 < n ? dp[5] : 0), (i+6 < n ? dp[6] : 0)));
            }

            for(int j = 6; j >= 2; j--) {
                dp[j] = dp[j-1];
            }

            dp[1] = Math.max(a, Math.max(b, c));
        }

        return dp[1];
    }
}