class Solution {
    public boolean isZeroArray(int[] nums, int[][] queries) {
        int n = nums.length;
        int m = queries.length;
        int[] prefix = new int[n+1];
        for(int i = 0; i < m; i++) {
            prefix[queries[i][0]]--;
            prefix[queries[i][1]+1]++;
        }
        for(int i = 1; i <= n; i++) {
            prefix[i] += prefix[i-1];
        }
        for(int i = 0; i < n; i++) {
            if(nums[i]+prefix[i] > 0) {
                return false;
            }
        }
        return true;
    }
}