class Solution {
public:
    bool predictTheWinner(vector<int>& nums) {
        int n = nums.size();

        int totalScore = 0;
        for(int num: nums) {
            totalScore += num;
        }

        //player 1 score
        int score = maxScore(0, n-1, nums);

        return score >= (totalScore-score);
    }

    int maxScore(int i, int j, vector<int>& nums) {
        if(i > j) {
            return 0;
        }

        // take from front
        int front = nums[i] + min(maxScore(i+2, j, nums),  maxScore(i+1, j-1, nums));

        //take from last
        int last = nums[j] + min(maxScore(i+1, j-1, nums), maxScore(i, j-2, nums));

        return max(front, last);
    }
};