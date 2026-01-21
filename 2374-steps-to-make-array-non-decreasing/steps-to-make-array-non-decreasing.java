class Solution {
    public int totalSteps(int[] nums) {
        int n = nums.length;
        int[] step = new int[n];
        Stack<Integer> st = new Stack<>();
        int ans = 0;
        for(int i = 0; i < n; i++) {
            int max = 0;
            while(!st.isEmpty() && nums[st.peek()] <= nums[i]) {
                max = Math.max(max, step[st.pop()]);
            }
            if(!st.isEmpty()) {
                step[i] = max+1;;
                ans = Math.max(ans, step[i]);
            }
            st.push(i);
        }
        return ans;
    }
}