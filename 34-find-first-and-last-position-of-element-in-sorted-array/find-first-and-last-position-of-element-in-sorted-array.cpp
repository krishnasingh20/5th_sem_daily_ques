class Solution {
public:
    vector<int> searchRange(vector<int>& nums, int target) {
        int first = lowerBound(nums, target);
        int last = upperBound(nums, target);
        return {first, last};
    }
    int lowerBound(vector<int>& nums, int target) {
        int idx = -1;
        int low = 0;
        int high = nums.size()-1;
        while(low <= high) {
            int mid = low + (high - low)/2;
            if(nums[mid] == target) {
                idx = mid;
                high = mid - 1;
            }
            else if(nums[mid] < target) {
                low = mid+1;
            }
            else {
                high = mid - 1;
            }
        }
        return idx;
    }
    int upperBound(vector<int>& nums, int target) {
        int idx = -1;
        int low = 0;
        int high = nums.size()-1;
        while(low <= high) {
            int mid = low + (high - low)/2;
            if(nums[mid] == target) {
                idx = mid;
                low = mid + 1;
            }
            else if(nums[mid] < target) {
                low = mid+1;
            }
            else {
                high = mid - 1;
            }
        }
        return idx;
    }
};