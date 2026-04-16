class Solution {
public:
    long long maxAlternatingSum(vector<int>& nums) {
        return bottomUp(nums);
    }
    long long bottomUp(vector<int>& nums) {
        int n = nums.size();

        vector<vector<long long>> dp(n+1, vector<long long>(3));

        for(int i = n-1; i >= 0; i--) {
            for(int state = 0; state <= 2; state++) {

                if(state == 0) {
                    long long curr = nums[i] + dp[i+1][2];
                    long long skip = dp[i+1][0];
                    dp[i][state] = max(curr, skip);
                }
                else if(state == 1) {
                    long long curr = nums[i] + dp[i+1][2];
                    long long skip = dp[i+1][1];
                    dp[i][state] = max(curr, skip);
                }
                else {
                    long long curr = -nums[i] + dp[i+1][1];
                    long long skip = dp[i+1][2];
                    dp[i][state] = max(curr, skip);
                }
            }
        }
        
        return dp[0][0];
    }
};