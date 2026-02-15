class Solution {
    public int[] xorQueries(int[] arr, int[][] queries) {
        int n = arr.length;
        int[] prefix = new int[n+1];
        for(int i = 0; i < n; i++) {
            prefix[i+1] = prefix[i] ^ arr[i];
        }
        int q = queries.length;
        int[] ans = new int[q];
        for(int i = 0; i < q; i++) {
            int l = queries[i][0];
            int r = queries[i][1];
            ans[i] = prefix[r+1]^prefix[l];
        }
        return ans;
    }
}