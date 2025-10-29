class Solution {
    public int maximalRectangle(char[][] matrix) {
        int n = matrix.length;
        int m = matrix[0].length;
        int[] arr = new int[m];
        int area = 0;
        for(int i = 0; i < n; i++) {
            for(int j = 0; j < m; j++) {
                if(matrix[i][j] == '0') {
                    arr[j] = 0;
                }
                else {
                    arr[j]++;
                }
            }
            area = Math.max(area, Area(arr));
        }
        return area;
    }
    public int Area(int[] arr) {
        Stack<Integer> st = new Stack<>();
        int area = 0;
        for(int i = 0; i <= arr.length; i++) {
            int val = i == arr.length?-1:arr[i];
            while(!st.isEmpty() && val < arr[st.peek()]) {
                int h = arr[st.pop()];
                int r = i;
                int l = st.isEmpty()?-1:st.peek();
                area = Math.max(area, h * (r - l - 1));
            }
            st.push(i);
        }
        return area;
    }
}