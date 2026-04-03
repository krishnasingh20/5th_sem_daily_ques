class Solution {
public:
    int lengthOfLIS(vector<int>& nums) {
        int n = nums.size();

        vector<int> dp(n);

        dp[0] = nums[0];
        int len = 1;

        for(int i = 1; i < n; i++) {
            if(dp[len-1] < nums[i]) {
                dp[len] = nums[i];
                len++;
            }
            else {
                int idx = search(dp, 0, len-1, nums[i]);
                dp[idx] = nums[i];
            }
        }

        return len;
    }

    int search(vector<int>& dp, int low, int high, int val) {
        int idx = 0;

        while(low <= high) {
            int mid = low + (high - low)/2;
            if(dp[mid] >= val) {
                idx = mid;
                high = mid - 1;
            }
            else {
                low = mid + 1;
            }
        }

        return idx;
    }
};