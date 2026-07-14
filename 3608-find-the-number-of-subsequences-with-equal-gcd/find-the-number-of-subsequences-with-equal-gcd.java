class Solution {
    static final int MOD = 1000000007;
    public int subsequencePairCount(int[] nums) {
        int max = 0;

        for(int num: nums) {
            max = Math.max(max, num);
        }

        return bottomUp(nums, max);
    }

    private int GCD(int a, int b) {
        return (b == 0 ? a : GCD(b, a % b));
    }

    public int bottomUp(int[] nums, int max) {
        int n = nums.length;
        int[][][] dp1 = new int[n+1][max+1][max+1];

        for(int j = 1; j <= max; j++) {
            dp1[n][j][j] = 1;
        }

        for(int i = n - 1; i >= 0; i--) {
            for(int j = 0; j <= max; j++) {
                for(int k = 0; k <= max; k++) {
                    int newSub1 = j == 0 ? nums[i] : GCD(j, nums[i]);
                    int newSub2 = k == 0 ? nums[i] : GCD(k, nums[i]);

                    int a = dp1[i+1][newSub1][k];
                    int b = dp1[i+1][j][newSub2];
                    int skip = dp1[i+1][j][k];

                    dp1[i][j][k] = ((a + b) % MOD + skip) % MOD;
                }
            }
        }

        return dp1[0][0][0];
    }
}