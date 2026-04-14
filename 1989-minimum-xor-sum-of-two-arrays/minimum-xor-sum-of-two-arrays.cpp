class Solution {
public:
    int minimumXORSum(vector<int>& nums1, vector<int>& nums2) {

        int n = nums1.size();
        vector<vector<int>> dp(n, vector<int>((1 << n), -1));

        return minXor(0, 0, n, nums1, nums2, dp);
    }

    int minXor(int i, int mask, int n, vector<int>& nums1, vector<int>& nums2, vector<vector<int>>& dp){
        if (i == n) {
            return 0;
        }

        if(dp[i][mask] != -1) {
            return dp[i][mask];
        }

        int ans = INT_MAX;;

        for(int j = 0; j < n; j++) {
            if((mask & (1 << j)) != 0) {
                continue;
            }

            int curr = (nums1[i] ^ nums2[j]) + minXor(i+1, (mask | (1 << j)), n, nums1, nums2, dp);

            ans = min(ans, curr);
        }

        return dp[i][mask] = ans;
    }
};