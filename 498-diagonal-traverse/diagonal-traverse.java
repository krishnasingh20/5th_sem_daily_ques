class Solution {
    public int[] findDiagonalOrder(int[][] mat) {
        int n = mat.length;
        int m = mat[0].length;
        int[] ans=  new int[n*m];
        int idx = 0;
        boolean flag = true;
        for(int i = 0; i < n; i++) {
            int j = i;
            int k = 0;
            int idx1 = idx;
            while(j >= 0 && k <= m-1) {
                ans[idx++] = mat[j][k];
                j--;
                k++;
            }
            if(!flag){
                reverse(ans, idx1, idx - 1);
            }
            flag = !flag;
        }
        for(int i = 1; i < m; i++) {
            int j = i;
            int k = n-1;
            int idx1 = idx;
            while(j < m && k >= 0) {
                ans[idx++] = mat[k][j];
                j++;
                k--;
            }
            if(!flag){
                reverse(ans, idx1, idx - 1);
            }
            flag = !flag;
        }
        return ans;
    }
    public void reverse(int[] arr, int i, int j) {
        while(i <= j) {
            int temp = arr[i];
            arr[i] = arr[j];
            arr[j] = temp;
            i++;
            j--;
        }
    }
}