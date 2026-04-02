class Solution {
public:
    int minSwap(vector<int>& nums1, vector<int>& nums2) {

        vector<vector<int>> dp(nums1.size(), vector<int>(2, -1));

        return minOpr(nums1, nums2, 0, 0, dp);
    }

    int minOpr(vector<int>& nums1, vector<int>& nums2, int i, int state, vector<vector<int>>& dp) {
        if(i == nums1.size()) {
            return 0;
        }

        if(dp[i][state] != -1) {
            return dp[i][state];
        }

        int ans = INT_MAX / 2;

        if(i == 0) {
            //check without swap possible to make strictly increasing
            int opr1 = minOpr(nums1, nums2, i+1, 0, dp);
            //check after swap possible to make strictly increasing
            int opr2 = 1 + minOpr(nums1, nums2, i+1, 1, dp);
            ans = min(opr1, opr2);
        }
        else if(state == 0) {
            //check without swap possible to make strictly increasing
            if(nums1[i] > nums1[i-1] && nums2[i] > nums2[i-1]) {
                int opr = minOpr(nums1, nums2, i+1, 0, dp);
                ans = opr;
            }
            //check after swap possible to make strictly increasing
            if(nums2[i] > nums1[i-1] && nums1[i] > nums2[i-1]) {
                int opr = 1 + minOpr(nums1, nums2, i+1, 1, dp);
                ans = min(ans, opr);
            }
        }
        else {
            //check without swap possible to make strictly increasing
            if(nums1[i] > nums2[i-1] && nums2[i] > nums1[i-1]) {
                int opr = minOpr(nums1, nums2, i+1, 0, dp);
                ans = opr;
            }
            //check after swap possible to make strictly increasing
            if(nums2[i] >  nums2[i-1] && nums1[i] > nums1[i-1]) {
                int opr = 1 + minOpr(nums1, nums2, i+1, 1, dp);
                ans = min(ans, opr);
            }
        }

        return dp[i][state] = ans;
    }
};