class Solution {
public:
    long long maxAlternatingSum(vector<int>& nums) {
        return bottomUp(nums);
    }
    long long bottomUp(vector<int>& nums) {
        int n = nums.size();

        long long next0 = 0, next1 = 0, next2 = 0;

        for(int i = n-1; i >= 0; i--) {
            long long curr0 = 0, curr1 = 0, curr2 = 0;
            for(int state = 0; state <= 2; state++) {

                if(state == 0) {
                    long long curr = nums[i] + next2;
                    long long skip = next0;
                    curr0 = max(curr, skip);
                }
                else if(state == 1) {
                    long long curr = nums[i] + next2;
                    long long skip = next1;
                    curr1 = max(curr, skip);
                }
                else {
                    long long curr = -nums[i] + next1;
                    long long skip = next2;
                    curr2 = max(curr, skip);
                }
            }

            next0 = curr0;
            next1 = curr1;
            next2 = curr2;
        }

        return next0;
    }
};