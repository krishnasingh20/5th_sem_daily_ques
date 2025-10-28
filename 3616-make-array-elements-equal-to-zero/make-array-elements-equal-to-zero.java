class Solution {
    public int countValidSelections(int[] nums) {
        int sum = 0;
        for(int num: nums) {
            sum += num;
        }
        int ans = 0;
        int curr = 0;
        for(int i = 0; i < nums.length; i++) {
            curr += nums[i];
            if(nums[i] == 0) {
                int right = sum - curr;
                if(curr == right) {
                    ans += 2;
                }
                else if(Math.abs(curr - right) == 1) {
                    ans++;
                }
            }
        }
        return ans;
    }
}