class Solution {
    public int minZeroArray(int[] nums, int[][] queries) {
        int m = queries.length;
        int ans = -1;
        int low = -1;
        int high = m-1;
        while(low <= high) {
            int mid = low + (high - low)/2;
            if(possible(queries, nums, mid)) {
                ans = mid+1;
                high = mid - 1;
            }
            else {
                low = mid + 1;
            }
        }
        return ans;
    }
    private boolean possible(int[][] queries, int[] nums, int mid) {
        int n = nums.length;
        int[] diff = new int[n+1];
        for(int i = 0; i <= mid; i++) {
            int l = queries[i][0];
            int r = queries[i][1]+1;
            int val = queries[i][2];
            diff[l] += val;
            diff[r] -= val;
        }
        for(int i = 1; i <= n; i++) {
            diff[i] += diff[i-1];
        }
        for(int i = 0; i < n; i++) {
            if(diff[i] < nums[i]) {
                return false;
            }
        }
        return true;
    }
}