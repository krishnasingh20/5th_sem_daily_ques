class Solution {
    public int numSubarraysWithSum(int[] nums, int goal) {
        return count(nums, goal) - count(nums, goal - 1);
    }
    public int count(int[] nums, int goal) {
        int sum = 0;
        int ans = 0;
        int n = nums.length;
        int ei = 0;
        int si = 0;
        while(ei < n) {
            sum += nums[ei];
            while(sum > goal && si <= ei) {
                sum -= nums[si];
                si++;
            }
            ans += (ei - si + 1);
            ei++;
        }
        return ans;
    }
}