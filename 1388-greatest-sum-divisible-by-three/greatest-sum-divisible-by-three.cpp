class Solution {
public:
    int maxSumDivThree(vector<int>& nums) {
        vector<vector<int>> dp(nums.size(), vector<int>(3, -1));
        int ans = maxSum(nums, 0, 0, dp);
        return max(0, ans);
    }

    int maxSum(vector<int>& nums, int i, int rem, vector<vector<int>>& dp) {
        if(i == nums.size()) {
            if(rem == 0) {
                return 0;
            }
            return INT_MIN;
        }
        
        if(dp[i][rem] != -1) {
            return dp[i][rem];
        }

        int pick = nums[i] + maxSum(nums, i+1, (rem+nums[i])%3, dp);
        int skip = maxSum(nums, i+1, rem, dp);

        return dp[i][rem] = max(pick, skip);
    }
};