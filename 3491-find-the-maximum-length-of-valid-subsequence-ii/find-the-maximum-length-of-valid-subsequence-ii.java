class Solution {
    public int maximumLength(int[] nums, int k) {
        int n = nums.length;
        for(int i = 0; i < n; i++) {
            nums[i] = nums[i] % k;
        }
        int[][] sub = new int[n][k];
        sub[0][nums[0]] = 1;
        int ans = 0;
        for(int i = 1; i < n; i++) {
            for(int j = 0; j < i; j++) {
                int curr = (nums[i]+nums[j])%k;
                int temp = sub[j][curr] + 1;
                if(temp == 1) {
                    temp++;
                }
                sub[i][curr] = Math.max(sub[i][curr], temp);
                ans = Math.max(ans, sub[i][curr]);
            }
        }
        return ans;
    }
}