class Solution {
    public int[] canSeePersonsCount(int[] heights) {
        Stack<Integer> st = new Stack<>();
        int n = heights.length;
        int[] ans = new int[n];
        for(int i = 0; i < n; i++) {
            while(!st.isEmpty() && heights[st.peek()] < heights[i]) {
                ans[st.pop()]++;
            }
            if(!st.isEmpty()) {
                ans[st.peek()]++;
            }
            st.push(i);
        }
        return ans;
    }
}