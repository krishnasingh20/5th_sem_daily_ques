class Solution {
    public int[] cycleLengthQueries(int n, int[][] queries) {
        int q = queries.length;
        int[] ans = new int[q];
        for(int i = 0; i < q; i++) {
            int a = queries[i][0];
            int b = queries[i][1];
            ans[i] = cycleLength(a, b) + 1;//plus one for current addition of edge that forms cycle
        }
        return ans;
    }
    public int cycleLength(int a, int b) {
        int c = 0;
        while(a != b) {
            if(a > b) {
                a /= 2;
            }
            else {
                b /= 2;
            }
            c++;
        }
        return c;
    }
}