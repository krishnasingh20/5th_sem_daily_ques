class Solution {
    public int numberOfSubarrays(int[] nums, int k) {
        int n = nums.length;
        // subarray with less then k odd numbers
        int subarray1 = count(nums, k - 1);
        // subarrray with less then equal to k odd numbers
        int subarray2 = count(nums, k);
        return subarray2 - subarray1;
    }
    public int count(int[] nums, int k) {
        int si = 0;
        int ei = 0;
        int ans = 0;
        int crt_odd = 0;
        while(ei < nums.length) {
            if(nums[ei] % 2 != 0) {
                crt_odd++;
            }
            while(crt_odd > k) {
                if(nums[si] % 2 != 0) {
                    crt_odd--;
                }
                si++;
            }
            ans += (ei - si + 1);
            ei++;
        }
        return ans;
    }
}