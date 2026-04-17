class Solution {
public:
    int maxSumAfterPartitioning(vector<int>& arr, int k) {
        vector<int> dp(arr.size(), -1);

        return maxSum(arr, 0, k, dp);
    }

    int maxSum(vector<int>& arr, int i, int k, vector<int>& dp) {
        if(i == arr.size()) {
            return 0;
        }

        if(dp[i] != -1) {
            return dp[i];
        }

        int ans = 0;

        int n = min(i+k-1, (int)arr.size()-1);

        int mmax = 0;
        for(int j = i; j <= n; j++) {
            mmax = max(mmax, arr[j]);
            int curr = (j-i+1)*mmax + maxSum(arr, j+1, k, dp);
            ans = max(ans, curr);
        }

        return dp[i] = ans;
    }
};