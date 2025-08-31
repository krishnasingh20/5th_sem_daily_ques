class Solution {
    public int lengthOfLIS(int[] nums) {
        int[] LIS = new int[nums.length];
        // for evry single element it is ouw LIS 
        Arrays.fill(LIS, 1);
        for(int i = 1; i < nums.length; i++) {
            for(int j = i - 1; j >= 0; j--) {
                if(nums[j] < nums[i]) {
                    int l = LIS[j] + 1;
                    LIS[i] = Math.max(LIS[i], l); 
                }
            }
        }
        int max = LIS[0];
        for(int i = 1; i < LIS.length; i++) {
            max = Math.max(LIS[i], max);
        }
        return max;
    }
}