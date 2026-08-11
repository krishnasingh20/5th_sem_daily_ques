class Solution {
    public int missingInteger(int[] nums) {
        int sum = nums[0];

        for(int i = 1; i < nums.length; i++) {
            if(nums[i] != nums[i-1] + 1) {
                break;
            }
            sum += nums[i];
        }

        while(contains(sum, nums)) {
            sum++;
        }
        
        return sum;
    }

    public boolean contains(int val, int[] nums) {
        for(int num: nums) {
            if(num == val) {
                return true;
            }
        }
        return false;
    }
}