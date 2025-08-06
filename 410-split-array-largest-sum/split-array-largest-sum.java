class Solution {
    public int splitArray(int[] nums, int k) {
        int sum = 0;
        int max = Integer.MIN_VALUE;
        for(int num: nums) {
            sum += num;
            max = Math.max(num, max);
        }
        int low = max;
        int high = sum;
        int ans = 0;
        while(low <= high) {
            int mid = low + (high - low) / 2;
            if(ispossible(nums, mid, k)) {
                ans = mid;
                high = mid - 1;
            }
            else {
                low = mid + 1;
            }
        }
        return ans;
    }
    public boolean ispossible(int[] nums, int mid, int k) {
        int sum = 0;
        int split = 1;
        for(int i = 0; i < nums.length; i++) {
            if(sum + nums[i] > mid) {
                split++;
                sum = 0;
                if(split > k) {
                    return false;
                }
            }
            sum += nums[i];
        }
        return split <= k;
    }
}