class Solution {
    public int maximalRectangle(char[][] matrix) {
        int n = matrix.length;
        int m = matrix[0].length;
        int area = 0;
        int[] arr = new int[m];
        for(int i = 0; i < n; i++) {
            for(int j = 0; j < m; j++) {
                if(matrix[i][j] == '0') {
                    arr[j] = 0;
                }
                else {
                    arr[j]++;
                }
            }
            area = Math.max(area, LargestHistogram(arr));
        }
        return area;
    }
    public int LargestHistogram(int[] arr) {
        int m = arr.length;
        int area = 0;
        Stack<Integer> st = new Stack<>();
        for(int i = 0; i < m; i++) {
            while(!st.isEmpty() && arr[i] < arr[st.peek()]) {
                int h = arr[st.pop()];
                int r = i;
                if(st.isEmpty()) {
                    area = Math.max(area, h * r);
                }
                else {
                    int l = st.peek();
                    area = Math.max(area, h * (r - l - 1));
                }
            }
            st.push(i);
        }
        int r = m;
        while(!st.isEmpty()) {
            int h = arr[st.pop()];
            if(st.isEmpty()) {
                area = Math.max(area, h * r);
            }
            else {
                int l = st.peek();
                area = Math.max(area, h * (r - l - 1));
            }
        }
        return area;
    }
}