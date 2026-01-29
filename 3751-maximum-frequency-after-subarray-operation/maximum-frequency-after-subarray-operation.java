class Solution {
    public int maxFrequency(int[] nums, int k) {
        int idx = 0;
        for(int i = 0; i < nums.length; i++) {
            if(nums[i] == k) {
                idx++;
            }
        }
        int ans = 0;
        for(int i = 1; i <= 50; i++) {
            if(i == k) {
                continue;
            }
            int res = 0;
            int curr = 0;
            for(int num : nums) {
                if(num == i) {
                    curr++;
                }
                if(num == k) {
                    curr--;
                }
                if(curr < 0) {
                    curr = 0;
                }
                res = Math.max(res, curr);
            }
            ans = Math.max(ans, res);
        }
        return ans+idx;
    }
}