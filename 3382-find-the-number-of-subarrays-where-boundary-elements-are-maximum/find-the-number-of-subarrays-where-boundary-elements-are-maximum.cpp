class Solution {
public:
    long long numberOfSubarrays(vector<int>& nums) {

        stack<pair<int, int>> st;
        int n = nums.size();
        long long ans = 0;

        for(int i = 0; i < n; i++) {
            
            while(!st.empty() && nums[st.top().first] < nums[i]) {
                st.pop();
            }

            if(!st.empty()) {
                if(nums[st.top().first] == nums[i]) {
                    int val = st.top().second;
                    ans += val+1;
                    st.top().second = val+1;
                    continue;
                }
            }

            ans++;
            st.push({i, 1});
        }

        return ans;
    }
};