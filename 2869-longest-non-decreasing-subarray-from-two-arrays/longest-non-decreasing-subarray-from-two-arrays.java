class Solution {
    public int maxNonDecreasingLength(int[] A, int[] B) {
        int n = A.length;
        int[] dp1 = new int[n];
        int[] dp2 = new int[n];
        Arrays.fill(dp1, 1);
        Arrays.fill(dp2, 1);
        int ans = 1;
        for(int i = 1; i < n; i++) {
            if(A[i] >= A[i-1]) {
                dp1[i] = Math.max(dp1[i], dp1[i-1]+1);
            }
            if(A[i] >= B[i-1]) {
                dp1[i] = Math.max(dp1[i], dp2[i-1]+1);
            }
            if(B[i] >= B[i-1]) {
                dp2[i] = Math.max(dp2[i], dp2[i-1]+1);
            }
            if(B[i] >= A[i-1]) {
                dp2[i] = Math.max(dp2[i], dp1[i-1]+1);
            }
            ans = Math.max(ans, Math.max(dp1[i], dp2[i]));
        }
        return ans;
    }
}