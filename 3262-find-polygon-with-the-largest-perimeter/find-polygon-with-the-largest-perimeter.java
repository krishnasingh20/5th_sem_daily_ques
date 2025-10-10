class Solution {
    public long largestPerimeter(int[] nums) {
        Arrays.sort(nums);
        int n = nums.length;
        long prefixSum = 0;
        long ans = Long.MIN_VALUE;
        for(int i = 0; i < n; i++) {
            if(i+1 >= 3) {
                if(prefixSum > nums[i]) {
                    ans = Math.max(ans, prefixSum+nums[i]);
                }
            }
            prefixSum += nums[i];
        }
        return ans == Long.MIN_VALUE?-1:ans;
    }
}