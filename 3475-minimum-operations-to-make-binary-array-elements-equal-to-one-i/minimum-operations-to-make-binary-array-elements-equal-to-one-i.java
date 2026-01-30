class Solution {
    public int minOperations(int[] nums) {
        int opr = 0;
        for(int i = 0; i <= nums.length-3; i++) {
            if(nums[i] == 0) {
                opr++;
                nums[i] = 1;
                nums[i+1] = nums[i+1]==0?1:0;
                nums[i+2] = nums[i+2]==0?1:0;
            }
        }
        for(int i = 0; i < nums.length; i++) {
            if(nums[i] == 0) {
                return -1;
            }
        }
        return opr;
    }
}