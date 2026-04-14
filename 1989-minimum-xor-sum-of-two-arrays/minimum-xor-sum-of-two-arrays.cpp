class Solution {
public:
    int minimumXORSum(vector<int>& nums1, vector<int>& nums2) {

        int n = nums1.size();
        vector<int> dp((1 << n), -1);

        return minXor(0, n, nums1, nums2, dp);
    }

    int minXor(int mask, int n, vector<int>& nums1, vector<int>& nums2, vector<int>& dp){
        int i = setBitCount(mask);

        if(i == n) {
            return 0;
        }

        if(dp[mask] != -1) {
            return dp[mask];
        }

        int ans = INT_MAX;;

        for(int j = 0; j < n; j++) {
            if((mask & (1 << j)) != 0) {
                continue;
            }

            int curr = (nums1[i] ^ nums2[j]) + minXor((mask | (1 << j)), n, nums1, nums2, dp);

            ans = min(ans, curr);
        }

        return dp[mask] = ans;
    }

    int setBitCount(int n) {
        int c = 0;
        
        while(n > 0) {
            c++;
            n = (n & (n-1));
        }

        return c;
    }
};