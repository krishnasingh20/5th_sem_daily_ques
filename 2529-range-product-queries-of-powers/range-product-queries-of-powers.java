class Solution {
    public int[] productQueries(int n, int[][] queries) {
        int bit = Integer.bitCount(n);
        long[] arr = new long[bit];
        String s = Integer.toBinaryString(n);
        int j = 0;
        int idx = 0;
        for(int i = s.length() - 1; i >= 0; i--) {
            if(s.charAt(i) == '1') {
                long val = (long)Math.pow(2, j);
                arr[idx++] = val;
            }
            j++;
        }
        int[] ans = new int[queries.length];
        idx = 0;
        for(int[] query: queries) {
            int left = query[0];
            int right = query[1];
            long cur = 1;
            for(j = left; j <= right; j++) {
                cur = (cur * arr[j]) % 1000000007;
            }
            ans[idx++] = (int)cur;
        }
        return ans;
    }
}