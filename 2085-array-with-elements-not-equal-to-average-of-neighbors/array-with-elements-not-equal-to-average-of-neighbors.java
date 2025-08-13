class Solution {
    public int[] rearrangeArray(int[] nums) {
        if(nums.length <= 2) {
            return nums;
        }
        Arrays.sort(nums);
        int[] ans = new int[nums.length];
        int idx = 0;
        for(int i = 1; i < nums.length; i += 2) {
            ans[i] = nums[idx++];
        } 
        for(int i = 0; i < nums.length; i += 2) {
            ans[i] = nums[idx++];
        }
        return ans;
    }
}