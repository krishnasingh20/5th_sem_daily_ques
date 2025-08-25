class Solution {
    public int[] findDiagonalOrder(int[][] mat) {
        int n = mat.length;
        int m = mat[0].length;
        int[] ans=  new int[n*m];
        int idx = 0;
        ArrayList<Integer> ll = new ArrayList<>();
        // add upper half
        boolean flag = true;
        for(int i = 0; i < n; i++) {
            int j = i;
            int k = 0;
            while(j >= 0 && k <= m-1) {
                ll.add(mat[j][k]);
                j--;
                k++;
            }
            if(flag) {
                for(int l = 0; l < ll.size(); l++) {
                    ans[idx++] = ll.get(l);
                }
                flag = false;
            }
            else {
                Collections.reverse(ll);
                for(int l = 0; l < ll.size(); l++) {
                    ans[idx++] = ll.get(l);
                }
                flag = true;
            }
            ll.clear();
        }
        for(int i = 1; i < m; i++) {
            int j = i;
            int k = n-1;
            while(j < m && k >= 0) {
                ll.add(mat[k][j]);
                j++;
                k--;
            }
            if(flag) {
                for(int l = 0; l < ll.size(); l++) {
                    ans[idx++] = ll.get(l);
                }
                flag = false;
            }
            else {
                Collections.reverse(ll);
                for(int l = 0; l < ll.size(); l++) {
                    ans[idx++] = ll.get(l);
                }
                flag = true;
            }
            ll.clear();
        }
        return ans;
    }
}