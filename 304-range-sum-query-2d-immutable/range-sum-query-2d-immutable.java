class NumMatrix {
    int[][] arr;
    public NumMatrix(int[][] matrix) {
        arr = matrix;
        prefixSum();
    }
    
    public int sumRegion(int row1, int col1, int row2, int col2) {
        int ans = 0;
        for(int i = row1; i <= row2; i++) {
            int left = col1 == 0?0:arr[i][col1-1];
            int right = arr[i][col2];
            ans += right - left;
        }
        return ans;
    }
    public void prefixSum() {
        for(int i = 0; i < arr.length; i++) {
            for(int j = 1; j < arr[0].length; j++) {
                arr[i][j] = arr[i][j] + arr[i][j-1];
            }
        }
    }
}

/**
 * Your NumMatrix object will be instantiated and called as such:
 * NumMatrix obj = new NumMatrix(matrix);
 * int param_1 = obj.sumRegion(row1,col1,row2,col2);
 */