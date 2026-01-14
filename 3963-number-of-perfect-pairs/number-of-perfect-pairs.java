class Solution {
    public long perfectPairs(int[] nums) {
        int n = nums.length;
        for(int i = 0; i < n; i++) {
            nums[i] = Math.abs(nums[i]);
        }
        Arrays.sort(nums);
        long ans = 0;
        for(int i = 1; i < n; i++) {
            int low = 0;
            int high = i-1;
            int idx = -1;
            int target = nums[i]/2;
            if((nums[i] & 1) == 1) {
                target++;
            }
            while(low <= high) {
                int mid = low + (high-low)/2;
                if(nums[mid] >= target) {
                    idx = mid;
                    high = mid - 1;
                }
                else {
                    low = mid + 1;
                }
            }
            if(idx != -1) {
                ans += (i - idx);
            }
        }
        return ans;
    }
}