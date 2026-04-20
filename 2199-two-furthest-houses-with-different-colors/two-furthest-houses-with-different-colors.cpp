class Solution {
public:
    int maxDistance(vector<int>& colors) {
        int prev1 = -1;
        int prev2 = -1;
        int n = colors.size();
        int ans = 0;
        for(int i = 0; i < n; i++) {
            if(prev2 == -1) {
                prev2 = i;
            }
            if(prev1 == -1 && colors[i] != colors[prev2]) {
                prev1 = prev2;
                prev2 = i;
            }

            if(prev1 != -1 && colors[i] != colors[prev1]) {
                ans = max(ans, i - prev1);
            }
            if(colors[i] != colors[prev2]) {
                ans = max(ans, i - prev2);
            }
        }

        return ans;
    }
};