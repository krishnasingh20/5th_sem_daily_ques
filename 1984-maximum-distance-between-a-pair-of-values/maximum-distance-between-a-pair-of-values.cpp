class Solution {
public:
    int maxDistance(vector<int>& nums1, vector<int>& nums2) {
        int ans = 0;
        int n = nums2.size();

        for(int i = 0; i < n; i++) {
            int idx = search(nums1, nums2[i]);

            if(idx != -1 && idx <= i) {
                ans = max(ans, (i-idx));
            }
        }

        return ans;
    }

    int search(vector<int>& nums, int val) {
        int low = 0;
        int high = nums.size()-1;
        int idx = -1;
        
        while(low <= high) {
            int mid = low + (high-low)/2;
            if(nums[mid] <= val) {
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