class Solution {
    public List<Integer> spiralOrder(int[][] matrix) {
        List<Integer> ans = new ArrayList<>();
        int m = matrix.length;
        int n = matrix[0].length;
        int total = m*n;
        int c = 1;
        int minc = 0;
        int minr = 0;
        int maxc = n - 1;
        int maxr = m - 1;
        while(c <= total) {
            // top side
            for(int i = minc; i <= maxc && c <= total; i++) {
                ans.add(matrix[minr][i]);
                c++;
            }
            minr++;
            //right side
            for(int i = minr; i <= maxr && c <= total; i++) {
                ans.add(matrix[i][maxc]);
                c++;
            }
            maxc--;
            //bottom side
            for(int i = maxc; i >= minc && c <= total; i--) {
                ans.add(matrix[maxr][i]);
                c++;
            }
            maxr--;
            //left side
            for(int i = maxr; i >= minr && c <= total; i--) {
                ans.add(matrix[i][minc]);
                c++;
            }
            minc++;
        }
        return ans;
    }
}