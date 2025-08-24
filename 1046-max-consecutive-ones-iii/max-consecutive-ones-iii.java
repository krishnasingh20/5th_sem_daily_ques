class Solution {
    public int longestOnes(int[] nums, int k) {
        int ei = 0;
        int si = 0;
        int ans = 0;
        int cnt = 0;
        while(ei < nums.length) {
            if(nums[ei] == 0) {
                cnt++;
            }
            while(cnt > k) {
                if(nums[si] == 0) {
                    cnt--;
                }
                si++;
            }
            ans = Math.max(ans, (ei-si+1));
            ei++;
        }
        return ans;
    }
}