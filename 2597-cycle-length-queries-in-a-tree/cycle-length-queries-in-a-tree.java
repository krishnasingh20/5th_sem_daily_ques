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
    public int cycleLength(int a, int b) {//here i am finding lowest common ancestor of both the node
        int c = 0;
        while(a != b) {
            if(a > b) {
                a >>= 1;
            }
            else {
                b >>= 1;
            }
            c++;
        }
        return c;
    }
}