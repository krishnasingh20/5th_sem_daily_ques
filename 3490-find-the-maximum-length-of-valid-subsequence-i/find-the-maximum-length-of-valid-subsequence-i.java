class Solution {
    public int maximumLength(int[] nums) {
        int n = nums.length;
        for(int i = 0; i < n; i++) {
            nums[i] = (nums[i] % 2);
        }
        int one = 0;
        int zero = 0;
        int alt = 1;
        int prev = nums[0];
        for(int i = 0; i < n; i++) {
            if(nums[i] == 0) {
                zero++;
                if(prev == 1) {
                    alt++;
                    prev = 0;
                }
            }
            else {
                one++;
                if(prev == 0) {
                    alt++;
                    prev = 1;
                }
            }
        }
        return Math.max(one, Math.max(zero, alt));
    }
}