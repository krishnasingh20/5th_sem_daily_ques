class Solution {
    int ans = 0;
    public int countValidSelections(int[] nums) {
        for(int i = 0; i < nums.length; i++) {
            if(nums[i] == 0) {
                // left
                move(nums, i, true, false);
                // right
                move(nums, i, false, true);
            }
        }
        return ans;
    }
    public void move(int[] nums, int curr, boolean left, boolean right) {
        if(curr < 0 || curr >= nums.length) {
            boolean flag = false;
            for(int i = 0; i < nums.length; i++) {
                if(nums[i] != 0) {
                    flag = true;
                }
            }
            if(!flag) {
                ans++;
            }
            return;
        }
        if(left) {
            if(nums[curr] == 0) {
                move(nums, curr - 1, true, false);
            }
            else if(nums[curr] > 0){
                nums[curr]--;
                move(nums, curr+1, false, true);
                nums[curr]++;
            }
        }
        else if(right) {
            if(nums[curr] == 0) {
                move(nums, curr + 1, false, true);
            }
            else if(nums[curr] > 0){
                nums[curr]--;
                move(nums, curr-1, true, false);
                nums[curr]++;
            }
        }
    }
}