class Solution {
    public int totalHammingDistance(int[] nums) {
        return totalHammingDis(nums);
    }
    private int totalHammingDis(int[] nums) {
        int n = nums.length;
        int ans = 0;
        int[][] count = new int[n][31];
        for(int i = 0; i <= 30; i++) {
            if((nums[0] & (1<<i)) != 0) {
                count[0][i] = 1;
            }
        }
        for(int i = 1; i < n; i++) {
            for(int j = 0; j <= 30; j++) {
                if((nums[i] & (1<<j)) != 0) {
                    ans += (i - count[i-1][j]);
                    count[i][j] = count[i-1][j] + 1;
                }
                else {
                    ans += count[i-1][j];
                    count[i][j] = count[i-1][j];
                }
            }
        }
        return ans;
    }
}