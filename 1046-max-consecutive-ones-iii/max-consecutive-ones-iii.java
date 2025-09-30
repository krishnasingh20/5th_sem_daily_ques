class Solution {
    public int longestOnes(int[] nums, int k) {
        int ans = 0;
        int ei = 0;
        int si = 0;
        int zero = 0;
        int n = nums.length;
        while(ei < n) {
            if(nums[ei] == 0) {
                zero++;
            }
            while(zero > k) {
                if(nums[si] == 0) {
                    zero--;
                }
                si++;
            }
            ans = Math.max(ans, (ei - si + 1));
            ei++;
        }
        return ans;
    }
}