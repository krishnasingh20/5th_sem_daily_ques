class Solution {
    public boolean search(int[] nums, int target) {
        int low = 0;
        int high = nums.length - 1;
         while(low < high && nums[low] == nums[low+1]) {
                low++;
            }
            while(high > low && nums[high] == nums[high-1]) {
                high--;
            }
        while(low <= high) {
            int mid = high + (low-high)/2;
            if(nums[mid] == target) {
                return true;
            }
            // left sorted half
            else if(nums[low] < nums[mid]) {
                if(nums[low] <= target && nums[mid] > target) {
                    high = mid - 1;
                    // while(high > low && nums[high] == nums[high-1]) {
                    //     high--;
                    // }
                }
                else {
                    low = mid + 1;
                    // while(low < high && nums[low] == nums[low+1]) {
                    //     low++;
                    // }
                }
            }
            // right sorted half 
            else {
                if(nums[high] >= target && nums[mid] < target) {
                    low = mid + 1;
                }
                else {
                    high = mid - 1;
                }
            }
        }
        return false;
    }
}