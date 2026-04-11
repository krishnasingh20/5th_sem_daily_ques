class Solution {
public:
    bool predictTheWinner(vector<int>& nums) {
        int n = nums.size();

        int totalScore = 0;
        for(int num: nums) {
            totalScore += num;
        }

        //player 1 score
        vector<vector<int>> dp(n, vector<int>(n, -1));
        int score = maxScore(0, n-1, nums, dp);

        return score >= (totalScore-score);
    }

    int maxScore(int i, int j, vector<int>& nums, vector<vector<int>>& dp) {
        if(i > j) {
            return 0;
        }

        if(dp[i][j] != -1) {
            return dp[i][j];
        }

        // take from front
        int front = nums[i] + min(maxScore(i+2, j, nums, dp),  maxScore(i+1, j-1, nums, dp));

        //take from last
        int last = nums[j] + min(maxScore(i+1, j-1, nums, dp), maxScore(i, j-2, nums, dp));

        return dp[i][j] = max(front, last);
    }
};