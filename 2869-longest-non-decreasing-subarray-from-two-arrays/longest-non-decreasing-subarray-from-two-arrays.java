class Solution {
    public int maxNonDecreasingLength(int[] A, int[] B) {
        int n = A.length;
        int a = 0;
        int b = 0;
        int c = 0;
        int d = 0;
        int dp1 = 1;
        int dp2 = 1;
        int ans = 1;
        for(int i = 1; i < n; i++) {
            a = b = c = d = 1;
            if(A[i] >= A[i-1]) {
                a = dp1 + 1;
            }
            if(A[i] >= B[i-1]) {
                b = dp2+1;
            }
            if(B[i] >= B[i-1]) {
                c = dp2+1;
            }
            if(B[i] >= A[i-1]) {
                d = dp1 + 1;
            }
            dp1 = Math.max(a, b);
            dp2 = Math.max(c, d);
            ans = Math.max(Math.max(dp1, dp2), ans);
        }
        return ans;
    }
}