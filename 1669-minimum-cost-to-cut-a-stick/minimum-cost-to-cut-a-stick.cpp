class Solution {
public:
    int minCost(int n, vector<int>& cuts) {
        sort(cuts.begin(), cuts.end());

        int m = cuts.size();
        vector<int> arr(m+2);

        arr[0] = 0;
        arr[m+1] = n;
        for(int i = 0; i < m; i++) {
            arr[i+1] = cuts[i];
        }

        vector<vector<int>> dp(m+1, vector<int>(m+1, -1));

        return minCost1(arr, 1, m, dp);
    }

    int minCost1(vector<int>& arr, int i, int j, vector<vector<int>>& dp) {
        if(i > j) {
            return 0;
        }

        if(dp[i][j] != -1) {
            return dp[i][j];
        }

        int ans = 1000000000;
        int n = arr[j+1] - arr[i-1]; //current length of stick 

        for(int k = i; k <= j; k++) {
            int curr = n + minCost1(arr, i, k-1, dp) + minCost1(arr, k+1, j, dp);
            ans = min(ans, curr);
        }

        return dp[i][j] = ans;
    }
};