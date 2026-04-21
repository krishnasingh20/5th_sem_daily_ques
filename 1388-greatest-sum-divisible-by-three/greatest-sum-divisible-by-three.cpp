class Solution {
public:
    int maxSumDivThree(vector<int>& nums) {
       return maxSum(nums);
    }

    int maxSum(vector<int>& nums) {
        int n = nums.size();
        vector<int> dp = {0, INT_MIN, INT_MIN};

        for(int i = n-1; i >= 0; i--) {
            vector<int> dp1(3);
            for(int rem = 0; rem < 3; rem++) {
                int pick = nums[i] + dp[(rem+nums[i])%3];
                int skip = dp[rem];
                dp1[rem] = max(pick, skip);
            }
            dp = dp1;
        }

        return dp[0];
    }
};