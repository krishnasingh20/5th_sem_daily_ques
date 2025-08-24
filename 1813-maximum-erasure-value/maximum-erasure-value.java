class Solution {
    public int maximumUniqueSubarray(int[] nums) {
        HashMap<Integer, Integer> map = new HashMap<>();
        int ei = 0;
        int si = 0;
        long ans = 0;
        long sum = 0;
        while(ei < nums.length) {
            sum += nums[ei];
            map.put(nums[ei], map.getOrDefault(nums[ei], 0) + 1);
            while(map.get(nums[ei])> 1) {
                sum -= nums[si];
                map.put(nums[si], map.get(nums[si]) - 1);
                si++;
            }
            ans = Math.max(ans, sum);
            ei++;
        }
        return (int)ans;
    }
}