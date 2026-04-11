class Solution {
public:
    int minimumDistance(vector<int>& nums) {
        int n = nums.size();
        vector<vector<int>> arr(n+1, vector<int>(2, -1));

        int ans = INT_MAX;

        for(int i = 0; i < n; i++) {
            if(arr[nums[i]][0] == -1) {
                arr[nums[i]][0] = arr[nums[i]][1];
                arr[nums[i]][1] = i;
            }
            else {
                int dist = (arr[nums[i]][1] - arr[nums[i]][0]) + (i - arr[nums[i]][1]) + (i - arr[nums[i]][0]);
                ans = min(ans, dist);
                arr[nums[i]][0] = arr[nums[i]][1];
                arr[nums[i]][1] = i;
            }
        }

        return ans==INT_MAX?-1:ans;
    }
};