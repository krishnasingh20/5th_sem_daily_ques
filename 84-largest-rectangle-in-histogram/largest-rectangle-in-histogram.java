class Solution {
    public int largestRectangleArea(int[] heights) {
        int ans = 0;
        int n = heights.length;
        Stack<Integer> st = new Stack<>();
        for(int i = 0; i < n; i++) {
            while(!st.isEmpty() && heights[i] < heights[st.peek()]) {
                int h = heights[st.pop()];
                if(st.isEmpty()) {
                    ans = Math.max(ans, h*i);
                }
                else{
                    ans = Math.max(ans, h*(i-st.peek()-1));
                }
            }
            st.push(i);
        }
        while(!st.isEmpty()) {
            int h = heights[st.pop()];
            if(st.isEmpty()) {
                ans = Math.max(ans, h*n);
            }
            else {
                ans = Math.max(ans, h*(n-st.peek()-1));
            }
        }
        return ans;
    }
}