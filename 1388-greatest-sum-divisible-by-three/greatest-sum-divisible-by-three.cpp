class Solution {
public:
    int maxSumDivThree(vector<int>& nums) {
        vector<vector<long long>> dp(nums.size(), vector<long long>(3, -1));
        long long ans = maxSum(nums, 0, 0, dp);
        return max(0, (int)ans);
    }

    long long maxSum(vector<int>& nums, int i, int rem, vector<vector<long long>>& dp) {
        if(i == nums.size()) {
            if(rem == 0) {
                return 0;
            }
            return INT_MIN;
        }
        
        if(dp[i][rem] != -1) {
            return dp[i][rem];
        }

        long long pick = nums[i] + maxSum(nums, i+1, (rem+nums[i])%3, dp);
        long long skip = maxSum(nums, i+1, rem, dp);

        return dp[i][rem] = max(pick, skip);
    }
};