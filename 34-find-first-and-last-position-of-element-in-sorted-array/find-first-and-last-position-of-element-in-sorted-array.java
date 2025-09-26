class Solution {
    public int[] searchRange(int[] nums, int target) {
        int low = 0;
        int high = nums.length - 1;
        while(low <= high) {
            int mid = low + (high - low) / 2;
            if(nums[mid] == target) {
                int start = mid;
                int end = mid;
                while(start > 0 && nums[start] == nums[start - 1]) {
                    start--;
                }
                while(end < nums.length - 1 && nums[end] == nums[end+1]) {
                    end++;
                }
                return new int[]{start, end};
            }
            else if(nums[mid] < target) {
                low = mid + 1;
            }
            else {
                high = mid - 1;
            }
        }
        return new int[]{-1, -1};
    }
}