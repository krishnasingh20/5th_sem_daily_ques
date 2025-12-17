class Solution {
    public int numberOfArithmeticSlices(int[] nums) {
        if(nums.length <= 2) {
            return 0;
        }
        int diff = nums[1] - nums[0];
        int count = 1;
        int ans = 0;
        for(int i = 2; i < nums.length; i++) {
            if(nums[i] - nums[i-1] == diff) {
                ans += count;
                count++;
            }
            else {
                diff = nums[i] - nums[i - 1];
                count = 1;
            }
        }
        return ans;
    }
}