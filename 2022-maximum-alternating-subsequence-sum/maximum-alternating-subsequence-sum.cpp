class Solution {
public:
    long long maxAlternatingSum(vector<int>& nums) {
        int n = nums.size();
        vector<vector<long long>> dp(n, vector<long long>(3, -1));
        return maxSum(nums, 0, 0, dp);
    }

    long long maxSum(vector<int>& nums, int i, int state, vector<vector<long long>>& dp) {
        if(i == nums.size()) {
            return 0;
        }

        if(dp[i][state] != -1) {
            return dp[i][state];
        }

        if(state == 0) {
            long long curr = nums[i] + maxSum(nums, i+1, 2, dp);
            long long skip = maxSum(nums, i+1, 0, dp);
            return dp[i][state] = max(curr, skip);
        }
        else if(state == 1) {
            long long curr = nums[i] + maxSum(nums, i+1, 2, dp);
            long long skip = maxSum(nums, i+1, 1, dp);
            return dp[i][state] = max(curr, skip);
        }
        else {
            long long curr = -nums[i] + maxSum(nums, i+1, 1, dp);
            long long skip = maxSum(nums, i+1, 2, dp);
            return dp[i][state] = max(curr, skip);
        }
    }
};