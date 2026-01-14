class Solution {
    public boolean[] pathExistenceQueries(int n, int[] nums, int maxDiff, int[][] queries) {
        // below array will tell where the connection is breaking
        int[] connection = new int[n];
        Arrays.fill(connection, -1);
        for(int i = 1; i < n; i++) {
            if(nums[i] - nums[i-1] > maxDiff) {
                connection[i-1] = i-1;
            }
        }
        for(int i = n-2; i >= 0; i--) {
            if(connection[i] != -1) {
                continue;
            }
            if(connection[i+1] != -1) {
                connection[i] = connection[i+1];
            }
        }
        int m = queries.length;
        boolean[] ans = new boolean[m];
        for(int i = 0; i < m; i++) {
            if(queries[i][0] == queries[i][1]) {
                ans[i] = true;
                continue;
            }
            //--> take path from u to v (smallest node to largest because if path form one end possible then it will also possible from another end)
            int u = Math.min(queries[i][0], queries[i][1]);
            int v = Math.max(queries[i][0], queries[i][1]);
            if(connection[u] != -1 && connection[u] < v) {
                continue;
            }
            ans[i] = true;
        }
        return ans;
    }
}