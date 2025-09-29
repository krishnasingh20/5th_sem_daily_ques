class Solution {
    public int[] maxSlidingWindow(int[] nums, int k) {
        int[] ans = new int[nums.length - k + 1];
        int[] premax = new int[nums.length];
        int[] suffmax = new int[nums.length];
        premax[0] = nums[0];
        for(int i = 1; i < nums.length; i++) {
            if(i % k == 0) {
                premax[i] = nums[i];
            }
            else {
                premax[i] = Math.max(premax[i-1], nums[i]);
            }
        }
        suffmax[nums.length-1] = nums[nums.length-1];
        for(int i = nums.length - 2; i >= 0; i--) {
            if((i+1)%k == 0) {
                suffmax[i] = nums[i];
            }
            else {
                suffmax[i] = Math.max(suffmax[i+1], nums[i]);
            }
        }
        for(int i = 0; i < ans.length; i++) {
            ans[i] = Math.max(suffmax[i], premax[i+k-1]);
        }
        return ans;
    }
}