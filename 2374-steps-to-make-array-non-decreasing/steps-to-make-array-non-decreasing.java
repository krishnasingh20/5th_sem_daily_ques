class Solution {
    public int totalSteps(int[] nums) {
        int ans = 0;
        Stack<int[]> st = new Stack<>();
        int n = nums.length;
        for(int i = 0; i < n; i++) {
            int max = 0;
            while(!st.isEmpty() && st.peek()[0] <= nums[i]) {
                max = Math.max(st.pop()[1], max);
            }
            if(!st.isEmpty()) {
                st.push(new int[]{nums[i], max+1});
                ans = Math.max(ans, max+1);
                continue;
            }
            st.push(new int[]{nums[i], 0});
        }
        return ans;
    }
}