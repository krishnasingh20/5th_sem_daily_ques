class Solution {
    int[] prefix;
    int n;
    int m;
    public int minZeroArray(int[] nums, int[][] queries) {
        n = nums.length;
        m = queries.length;
        prefix = new int[n+1];
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
        Arrays.fill(prefix, 0);
        for(int i = 0; i <= mid; i++) {
            int l = queries[i][0];
            int r = queries[i][1]+1;
            int val = queries[i][2];
            prefix[l] += val;
            prefix[r] -= val;
        }
        for(int i = 1; i <= n; i++) {
            prefix[i] += prefix[i-1];
        }
        for(int i = 0; i < n; i++) {
            if(prefix[i] < nums[i]) {
                return false;
            }
        }
        return true;
    }
}