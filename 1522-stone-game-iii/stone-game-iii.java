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
        int[] dp = new int[6];

        for(int i = n-1; i >= 0; i--) {
            int a = stone[i] + Math.min(dp[1], Math.min(dp[2], dp[3]));

            int b = Integer.MIN_VALUE;
            int c = Integer.MIN_VALUE;

            if(i+1 < n) {
                b = stone[i] + stone[i+1] + Math.min(dp[2], Math.min(dp[3], dp[4]));
            }

            if(i+2 < n) {
                c = stone[i] + stone[i+1] + stone[i+2] + Math.min(dp[3], Math.min(dp[4], dp[5]));
            }

            for(int j = 5; j >= 1; j--) {
                dp[j] = dp[j-1];
            }

            dp[0] = Math.max(a, Math.max(b, c));
        }

        return dp[0];
    }
}