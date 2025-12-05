class Solution {
    public int countPartitions(int[] nums) {
        int totalSum = 0;
        for(int num: nums) {
            totalSum += num;
        }
        int currSum = 0;
        int ans = 0;
        for(int i = 0; i < nums.length - 1; i++) {
            currSum += nums[i];
            int temp = Math.abs(totalSum - 2*currSum);
            if((temp & 1) == 0) {
                ans++;
            }
        }
        return ans;
    }
}