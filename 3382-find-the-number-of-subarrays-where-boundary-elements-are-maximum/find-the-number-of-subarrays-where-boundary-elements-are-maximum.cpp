class Solution {
public:
    long long numberOfSubarrays(vector<int>& nums) {
        unordered_map<int, int> map;
        stack<int> st;

        int n = nums.size();
        long long ans = 0;

        for(int i = 0; i < n; i++) {
            while(!st.empty() && nums[st.top()] < nums[i]) {
                if(map.count(nums[st.top()])) {
                    map.erase(nums[st.top()]);
                }
                st.pop();
            }
            
            st.push(i);
            int val = map[nums[i]];
            map[nums[i]] = val + 1;
            ans += val+1;
        }

        return ans;
    }
};