class Solution {
    public boolean[] pathExistenceQueries(int n, int[] nums, int maxDiff, int[][] queries) {
        TreeSet<Integer> set = new TreeSet<>();
        for(int i = 1; i < n; i++) {
            if(nums[i]-nums[i-1] > maxDiff) {
                set.add(i-1);
            }
        }
        int m = queries.length;
        boolean[] ans = new boolean[m];
        for(int i = 0; i < m; i++) {
            int u = Math.min(queries[i][0], queries[i][1]);
            int v = Math.max(queries[i][0], queries[i][1]);
            if(u == v) {
                ans[i] = true;
                continue;
            }
            Integer idx = set.ceiling(u);
            if(idx != null && idx < v) {
                continue;
            }
            ans[i] = true;
        }
        return ans;
    }
}