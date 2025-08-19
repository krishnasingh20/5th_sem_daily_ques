class Solution {
    public long zeroFilledSubarray(int[] nums) {
        long ans = 0;
        int start = -1;
        int end = -1;
        for(int i = 0; i < nums.length; i++) {
            if(nums[i] == 0) {
                if(start == -1) {
                    start = i;
                }
                end = i;
                ans += (end - start + 1);
            }
            else {
                start = -1;
                end = -1;
            }
        }
        return ans;
    }
}