class Solution {
public:
    int scoreDifference(vector<int>& nums) {
        int score1 = 0;
        int score2 = 0;
        bool p1 = true;
        bool p2 = false;
        int n = nums.size();
        for(int i = 0; i < n; i++) {
            if((nums[i] & 1)) {
                p1 = !p1;
                p2 = !p2;
            }
            if((i+1) % 6 == 0) {
                p1 = !p1;
                p2 = !p2;
            }
            if(p1) {
                score1 += nums[i];
            }
            else {
                score2 += nums[i];
            }
        }
        return score1 - score2;
    }
};