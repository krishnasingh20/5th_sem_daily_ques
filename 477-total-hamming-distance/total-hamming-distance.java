class Solution {
    public int totalHammingDistance(int[] nums) {
        return totalHammingDis(nums);
    }
    private int totalHammingDis(int[] nums) {
        int n = nums.length;
        int ans = 0;
        for(int i = 0; i<= 30; i++) {
            int one = 0;
            for(int j = 0; j < n; j++) {
                if((nums[j] & (1<<i)) != 0) {
                    ans += (j - one);
                    one++;
                }
                else {
                    ans += one;
                }
            }
        }
        return ans;
    }
}