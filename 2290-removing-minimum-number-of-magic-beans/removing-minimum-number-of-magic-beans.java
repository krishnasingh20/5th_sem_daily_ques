class Solution {
    public long minimumRemoval(int[] beans) {
        Arrays.sort(beans);
        int n = beans.length;
        long[] prefix = new long[n+1];
        for(int i = 0; i < n; i++) {
            prefix[i+1] = prefix[i]+beans[i];
        }
        long ans = Long.MAX_VALUE;
        int si = 0;
        for(int ei = 0; ei < n; ei++) {
            while(beans[ei] != beans[si]) {
                si++;
            }
            long curr = prefix[si] + (prefix[n] - prefix[ei]) - (long)beans[ei]*(n-ei);
            ans = Math.min(ans, curr);
        }
        return ans;
    }
}