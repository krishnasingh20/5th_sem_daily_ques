class Solution {
public:
    int maxGoodNumber(vector<int>& nums) {
        vector<vector<int>> permu = {{0,1,2},{0,2,1},{1,0,2},{1,2,0},{2,1,0},{2,0,1}};
        int ans = 0;
        for(int i = 0; i < 6; i++) {
            int pow = 1;
            int curr = 0;
            for(int j = 0; j < 3; j++) {
                int num = nums[permu[i][j]];
                while(num > 0) {
                    if((num & 1)) {
                        curr += pow;
                    }
                    num >>= 1;
                    pow *= 2;
                }
            }
            ans = max(ans, curr);
        }
        return ans;
    }
};