class Solution {
    public void rotate(int[][] matrix) {
        for(int i = 0; i < matrix.length; i++) {
            for(int j = i+1; j < matrix.length; j++) {
                int temp = matrix[i][j];
                matrix[i][j] = matrix[j][i];
                matrix[j][i] = temp;
            }
        }
        for(int i = 0; i < matrix.length; i++) {
            reverse(i, matrix);
        }
    }
    public void reverse(int row, int[][] matrix) {
        int i = 0;
        int j = matrix[0].length-1;
        while(i < j) {
            int temp = matrix[row][i];
            matrix[row][i] = matrix[row][j];
            matrix[row][j] = temp;
            i++;
            j--;
        }
    }
}