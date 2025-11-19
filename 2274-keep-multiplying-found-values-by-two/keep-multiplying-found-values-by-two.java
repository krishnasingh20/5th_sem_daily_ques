class Solution {
    public int findFinalValue(int[] nums, int o) {
        Arrays.sort(nums);
        for(int i = 0; i < nums.length; i++) {
            if(nums[i] == o) {
                o *= 2;
            }
        }
        return o;
    }
}