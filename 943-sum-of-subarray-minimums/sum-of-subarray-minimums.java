class Solution {
    public int sumSubarrayMins(int[] arr) {
        int n = arr.length;
        Stack<Integer> st = new Stack<>();
        
        int MOD = 1000000007;
        long ans = 0;

        for(int i = 0; i < n; i++) {
            while(!st.isEmpty() && arr[st.peek()] > arr[i]) {
                int j = st.pop();
                int l = (st.isEmpty() ? j+1 : j - st.peek());
                int r = i - j;
                ans = (ans + ((long)arr[j]*l*r) % MOD) % MOD;
            }
            st.push(i);
        }

        while(!st.isEmpty()) {
            int j = st.pop();
            int l = (st.isEmpty() ? j+1 : j - st.peek());
            int r = n - j;
            ans = (ans + ((long)arr[j]*l*r) % MOD) % MOD;
        }

        return (int)ans;
    }
}