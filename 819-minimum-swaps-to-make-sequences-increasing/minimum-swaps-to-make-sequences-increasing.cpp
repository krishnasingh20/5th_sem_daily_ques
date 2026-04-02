class Solution {
public:
    int minSwap(vector<int>& nums1, vector<int>& nums2) {
        return bottomUp(nums1, nums2);
    }

    int bottomUp(vector<int>& nums1, vector<int>& nums2) {
        int n = nums1.size();

        vector<vector<int>> dp(n+1, vector<int>(2));

        for(int i = n-1; i >= 0; i--) {
            if(i == 0) {
                dp[0][0] = min(dp[i+1][0], dp[i+1][1]+1);
                continue;
            }
            for(int state = 0; state <= 1; state++) {
                int ans = INT_MAX/2;

                if(state == 0) {
                    if(nums1[i] > nums1[i-1] && nums2[i] > nums2[i-1]) {
                        int opr = dp[i+1][0];
                        ans = opr;
                    }
                    if(nums2[i] > nums1[i-1] && nums1[i] > nums2[i-1]) {
                        int opr = 1 + dp[i+1][1];
                        ans = min(ans, opr);
                    }
                }
                else {
                    if(nums1[i] > nums2[i-1] && nums2[i] > nums1[i-1]) {
                        int opr = dp[i+1][0];
                        ans = opr;
                    }
                    if(nums2[i] >  nums2[i-1] && nums1[i] > nums1[i-1]) {
                        int opr = 1 + dp[i+1][1];
                        ans = min(ans, opr);
                    }
                }

                dp[i][state] = ans;
            }
        }

        return dp[0][0];
    }
};