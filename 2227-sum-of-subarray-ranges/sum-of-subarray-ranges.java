class Solution {
    public long subArrayRanges(int[] nums) {
        int n = nums.length;
        long ans = 0;
        Stack<Integer> st = new Stack<>();

        for(int i = 0; i < n; i++) {
            while(!st.isEmpty() && nums[st.peek()] > nums[i]) {
                int j = st.pop();
                int l = (st.isEmpty() ? j+1 : j - st.peek());
                int r = i - j;
                ans -= (long)nums[j]*l*r;
            }
            st.push(i);
        }

        while(!st.isEmpty()) {
            int j = st.pop();
            int l = (st.isEmpty() ? j+1 : j - st.peek());
            int r = n - j;
            ans -= (long)nums[j]*l*r;
        }

        for(int i = 0; i < n; i++) {
            while(!st.isEmpty() && nums[st.peek()] < nums[i]) {
                int j = st.pop();
                int l = (st.isEmpty() ? j+1 : j - st.peek());
                int r = i - j;
                ans += (long)nums[j]*l*r;
            }
            st.push(i);
        }

        while(!st.isEmpty()) {
            int j = st.pop();
            int l = (st.isEmpty() ? j+1 : j - st.peek());
            int r = n - j;
            ans += (long)nums[j]*l*r;
        }

        return ans;
    }
}