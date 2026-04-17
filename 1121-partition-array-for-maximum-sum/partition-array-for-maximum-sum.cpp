class Solution {
public:
    int maxSumAfterPartitioning(vector<int>& arr, int k) {
        return maxSum(arr, k);
    }

    int maxSum(vector<int>& arr, int k) {

        int n = arr.size();
        vector<int> dp(n+1);

        for(int i = n-1; i >= 0; i--) {

            int ans = 0;
            int len = min(i+k-1, n-1);
            int mmax = 0;

            for(int j = i; j <= len; j++) {
                mmax = max(mmax, arr[j]);

                int curr = (j-i+1)*mmax + dp[j+1];

                ans = max(ans, curr);
            }

            dp[i] = ans;
        }

        return dp[0];
    }
};