class Solution {
    public int maxFrequency(int[] nums, int k) {
        Arrays.sort(nums);
        int n = nums.length;
        int[] prefixSum = new int[n];
        prefixSum[0] = nums[0];
        for(int i = 1; i < n; i++) {
            prefixSum[i] = prefixSum[i-1]+nums[i];
        }
        int ans = 0;
        for(int i = 0; i < n; i++) {
            int low = 0;
            int high = i - 1;
            int idx = -1;
            while(low <= high) {
                int mid = low + (high - low)/2;
                int left = mid - 1 < 0?0: prefixSum[mid - 1];
                int right = prefixSum[i - 1];
                int total = ((i-1) - mid + 1) * nums[i];
                if(total - (right - left) <= k) {
                    idx = mid;
                    high = mid - 1;
                }
                else {
                    low = mid + 1;
                }
            }
            if(idx != -1) {
                ans = Math.max(i - idx + 1, ans);
            }
            else {
                ans = Math.max(ans, 1);
            }
        }
        return ans;
    }
}