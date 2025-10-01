class Solution {
    public int largestRectangleArea(int[] heights) {
        int ans = 0;
        int n = heights.length;
        Stack<Integer> st = new Stack<>();
        for(int i = 0; i <= n; i++) {
            int a = i == n?0:heights[i];
            while(!st.isEmpty() && a < heights[st.peek()]) {
                int h = heights[st.pop()];
                int leftsmaller = st.isEmpty()?-1:st.peek();
                int rightsmaller = i;
                int width = rightsmaller - leftsmaller - 1;
                ans = Math.max(ans, h*width);
            }
            st.push(i);
        }
        return ans;
    }
}