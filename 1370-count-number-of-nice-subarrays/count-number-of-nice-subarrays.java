class Solution {
    public int numberOfSubarrays(int[] nums, int k) {
        int n = nums.length;
        long totalSubarray = (long)n * (n + 1) / 2;
        // subarray with less then k odd numbers
        long subarray1 = lessThenK(nums, k);
        // subarrray with more then k odd numbers
        long subarray2 = moreThenK(nums, k);
        return (int)(totalSubarray - (subarray1 + subarray2));
    }
    public long lessThenK(int[] nums, int k) {
        int si = 0;
        int ei = 0;
        long ans = 0;
        int crt_odd = 0;
        while(ei < nums.length) {
            if(nums[ei] % 2 != 0) {
                crt_odd++;
            }
            while(crt_odd >= k) {
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
    public long moreThenK(int[] nums, int k) {
        int si = 0;
        int ei = 0;
        long ans = 0;
        int crt_odd = 0;
        while(ei < nums.length) {
            if(nums[ei] % 2 != 0) {
                crt_odd++;
            }
            while(crt_odd > k) {
                ans += (nums.length - ei);
                if(nums[si] % 2 != 0) {
                    crt_odd--;
                }
                si++;
            }
            ei++;
        }
        return ans;
    }
}