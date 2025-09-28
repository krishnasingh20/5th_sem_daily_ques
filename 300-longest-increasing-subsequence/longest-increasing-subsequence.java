class Solution {
    public int lengthOfLIS(int[] nums) {
        return LIS(nums);
    }
    public int LIS(int[] nums) {
        int[] lis = new int[nums.length];
        lis[0] = nums[0];
        int len = 1;
        for(int i = 1; i < nums.length; i++) {
            if(nums[i] > lis[len-1]) {
                lis[len] = nums[i];
                len++;
            }
            else {
                int idx = BinarySearch(lis, 0, len - 1, nums[i]);
                lis[idx] = nums[i];
            }
        }
        return len;
    }
    public int BinarySearch(int[] lis, int low, int high, int val) {
        int idx = 0;
        while(low <= high) {
            int mid = low + (high - low) / 2;
            if(lis[mid] >= val) {
                idx = mid;
                high = mid - 1;
            }
            else {
                low = mid + 1;
            }
        }
        return idx;
    }
}