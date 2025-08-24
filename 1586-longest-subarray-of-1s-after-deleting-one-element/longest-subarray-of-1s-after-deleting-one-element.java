class Solution {
    public int longestSubarray(int[] nums) {
        int cnt = 0;//it will tell current zero count
        int ei = 0;
        int si = 0;
        int ans = 0;
        int n = nums.length;
        while(ei < n) {
            if(nums[ei] == 0) {
                cnt++;
            }
            while(cnt > 1) {
                if(nums[si] == 0) {
                    cnt--;
                }
                si++;
            }
            ans = Math.max(ans, (ei - si));
            ei++;
        }
        return ans;
    }
}