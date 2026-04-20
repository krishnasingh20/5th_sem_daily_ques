class Solution {
    public long numberOfSubarrays(int[] nums) {
        int n = nums.length;
        long ans = 0;
        HashMap<Integer, Integer> map = new HashMap<>();
        Stack<Integer> st = new Stack<>();
        for(int i = 0; i < n; i++) {
            while(!st.isEmpty() && nums[st.peek()] < nums[i]) {
                map.put(nums[st.peek()], map.get(nums[st.peek()])-1);
                st.pop();
            }
            st.push(i);
            map.put(nums[i], map.getOrDefault(nums[i], 0)+1);
            ans += map.get(nums[i]);
        }
        return ans;
    }
}