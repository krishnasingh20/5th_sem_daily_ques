class Solution {
public:
    vector<int> survivedRobotsHealths(vector<int>& pos, vector<int>& h, string dir) {

        vector<pair<int, int>> arr;
        int n = pos.size();

        for(int i = 0; i < n; i++) {
            arr.push_back({pos[i], i});
        }

        sort(arr.begin(), arr.end(), [](pair<int, int> &a, pair<int, int> &b) {
            return a.first < b.first;
        });

        stack<pair<int, int>> st;

        for(int i = 0; i < n; i++) {
            bool flag = true;
            while(!st.empty() && dir[st.top().second] == 'R' && dir[arr[i].second] == 'L') {
                if(h[arr[i].second] == h[st.top().second]) {
                    st.pop();
                    flag = false;
                    break;
                }
                else if(h[arr[i].second] < h[st.top().second]) {
                    h[st.top().second]--;
                    flag = false;
                    break;
                }
                st.pop();
                h[arr[i].second]--;
            }
            if(flag) {
                st.push(arr[i]);
            }
        }

        vector<int> ans;
        
        while(!st.empty()) {
            pos[st.top().second] = -1;
            st.pop();
        }

        for(int i = 0; i < n; i++) {
            if(pos[i] == -1) {
                ans.push_back(h[i]);
            }
        }

        return ans;
    }
};