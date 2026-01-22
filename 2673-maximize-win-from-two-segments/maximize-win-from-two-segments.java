class Solution {
    public int maximizeWin(int[] positions, int k) {
        int n = positions.length;
        int[] prefix = new int[n+1];
        int ei = 0;
        int si = 0;
        while(ei < n) {
            while(positions[ei] - positions[si] > k) {
                positions[si] = ei;
                prefix[si] = ei - si;
                si++;
            }
            ei++;
        }
        while(si < ei) {
            prefix[si] = ei - si;
            positions[si] = ei;
            si++;
        }
        for(int i = n - 1; i >= 0; i--) {
            prefix[i] = Math.max(prefix[i], prefix[i+1]);
        }
        int ans = Integer.MIN_VALUE;
        for(int i = 0; i < n; i++) {
            int curr = (positions[i] - i) + prefix[positions[i]];
            ans = Math.max(ans, curr);
        }
        return ans;
    }
}