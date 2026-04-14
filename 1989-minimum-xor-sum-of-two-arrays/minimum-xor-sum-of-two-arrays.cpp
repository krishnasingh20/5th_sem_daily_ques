class Solution {
public:
    int minimumXORSum(vector<int>& nums1, vector<int>& nums2) {

        int n = nums1.size();

        return bottomUp(nums1, nums2, n);
    }

    int bottomUp(vector<int>& nums1, vector<int>& nums2, int n) {
        vector<int> dp((1 << n)+1);

        for(int mask = (1 << n)-1; mask >= 0; mask--) {
            int i = setBitCount(mask);

            if(i == n) {
                continue;
            }

            int ans = INT_MAX;

            for(int j = 0; j < n; j++) {
                if((mask & (1 << j)) != 0) {
                    continue;
                }

                int curr = (nums1[i] ^ nums2[j]) + dp[(mask | (1 << j))];

                ans = min(ans, curr);
            }

            dp[mask] = ans;
        }

        return dp[0];
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