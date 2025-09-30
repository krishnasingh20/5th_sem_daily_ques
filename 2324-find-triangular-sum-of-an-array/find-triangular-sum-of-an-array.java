class Solution {
    public int triangularSum(int[] nums) {
        for(int turn = 1; turn < nums.length; turn++) {
            for(int i = 0; i < nums.length - turn; i++) {
                nums[i] = (nums[i] + nums[i+1]) % 10;
            }
        }
        return nums[0];
    }
}