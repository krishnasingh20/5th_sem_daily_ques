class Solution {
public:
    int findUnsortedSubarray(vector<int>& nums) {
        int n = nums.size();
        int maxx = nums[0];
        int end = -1;
        for(int i = 1; i < n; i++) {
            if(nums[i] < maxx) {
                end = i;
            }
            maxx = max(maxx, nums[i]);
        }

        if(end == -1) {
            return 0;
        }

        int minn = nums[n-1];;
        int start = -1;

        for(int i = n-2; i >= 0; i--) {
            if(nums[i] > minn) {
                start = i;
            }
            minn = min(minn, nums[i]);
        }

        return end - start + 1;
    }
};