class Solution {
    public int findTargetSumWays(int[] nums, int target) {
        return way(nums, 0, 0, target);
    }

    public int way(int[] nums, int i, int curr, int target) {
        if(i == nums.length) {
            return (curr == target) ? 1 : 0;
        }
        return way(nums, i+1, curr - nums[i], target)+way(nums, i+1, curr+nums[i], target);
    }
}