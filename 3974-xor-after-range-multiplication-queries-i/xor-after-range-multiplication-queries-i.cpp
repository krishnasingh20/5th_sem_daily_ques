class Solution {
public:
    int xorAfterQueries(vector<int>& nums, vector<vector<int>>& queries) {

        int q = queries.size();
        int MOD = 1e9 + 7;

        for(int i = 0; i < q; i++) {
            int l = queries[i][0];
            int r = queries[i][1];
            int val = queries[i][3];
            int k = queries[i][2];

            for(int j = l; j <= r; j += k) {
                nums[j] = (1LL * nums[j] * val) % MOD;
            }
        }

        int ans = 0;
        for(auto &a: nums) {
            ans ^= a;
        }

        return ans;
    }
};