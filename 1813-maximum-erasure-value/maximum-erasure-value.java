class Solution {
    public int maximumUniqueSubarray(int[] nums) {
        int[] freq = new int[10001];
        int ei = 0;
        int si = 0;
        long ans = 0;
        long sum = 0;
        while(ei < nums.length) {
            sum += nums[ei];
            freq[nums[ei]]++;
            while(freq[nums[ei]] > 1) {
                sum -= nums[si];
                freq[nums[si]]--;
                si++;
            }
            ans = Math.max(ans, sum);
            ei++;
        }
        return (int)ans;
    }
}