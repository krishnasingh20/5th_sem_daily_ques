class Solution {
    public int maxSubarraySumCircular(int[] nums) {
        int total = totalSum(nums);
        int maxSum = maxSubarraySum(nums);
        int minSum = minSubarraySum(nums);
        if(total - minSum == 0) {
            return maxSum;
        }
        return Math.max(total-minSum, maxSum);
    }
    public int minSubarraySum(int[] nums) {
        int ans = Integer.MAX_VALUE;
        int sum = 0;
        for(int i = 0; i < nums.length; i++) {
            sum += nums[i];
            ans = Math.min(ans, sum);
            if(sum > 0) {
                sum = 0;
            }
        }
        return ans;
    }
    public int maxSubarraySum(int[] nums) {
        int ans = Integer.MIN_VALUE;
        int sum = 0;
        for(int i = 0; i < nums.length; i++) {
            sum += nums[i];
            ans = Math.max(ans, sum);
            if(sum < 0) {
                sum = 0;
            }
        }
        return ans;
    }
    public int totalSum(int[] nums) {
        int sum = 0;
        for(int num: nums) {
            sum += num;
        }
        return sum;
    }
}