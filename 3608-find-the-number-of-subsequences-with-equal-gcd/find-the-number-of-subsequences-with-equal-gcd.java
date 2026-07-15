class Solution {
    static final int MOD = 1000000007;
    int[][][] dp;
    int[][] gcd;
    public int subsequencePairCount(int[] nums) {
        int max = 0;

        for(int num: nums) {
            max = Math.max(max, num);
        }

        dp = new int[nums.length][max+1][max+1];

        for(int[][] d: dp) {
            for(int[] d1: d) {
                Arrays.fill(d1, -1);
            }
        }

        gcd = new int[max+1][max+1];

        for(int i = 1; i <= max; i++) {
            for(int j = 1; j <= max; j++) {
                gcd[i][j] = GCD(i, j);
            }
        }

        return count(nums, 0, 0, 0);
    }
    
    public int count(int[] nums, int i, int sub1, int sub2) {
        if(i == nums.length) {
            return (sub1 > 0 && sub2 > 0 && sub1 == sub2) ? 1 : 0;
        }

        if(dp[i][sub1][sub2] != -1) {
            return dp[i][sub1][sub2];
        }

        int newSub1 = sub1 == 0 ? nums[i] : gcd[sub1][nums[i]];
        int newSub2 = sub2 == 0 ? nums[i] : gcd[sub2][nums[i]];

        int a = count(nums, i+1, newSub1, sub2);
        int b = count(nums, i+1, sub1, newSub2);
        int skip = count(nums, i+1, sub1, sub2);

        return dp[i][sub1][sub2] = ((a + b) % MOD + skip) % MOD;
    }

    private int GCD(int a, int b) {
        return (b == 0 ? a : GCD(b, a % b));
    }
}