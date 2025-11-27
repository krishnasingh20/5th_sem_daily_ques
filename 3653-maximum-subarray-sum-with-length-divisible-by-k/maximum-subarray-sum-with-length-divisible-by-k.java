class Solution {
    public long maxSubarraySum(int[] nums, int k) {
        HashMap<Integer, Long> map = new HashMap<>();
        long ans = Long.MIN_VALUE;
        map.put(0, 0L);
        long prefixSum = 0;
        for(int i = 0; i < nums.length; i++) {
            prefixSum += nums[i];
            int rem = (i+1) % k;
            if(map.containsKey(rem)) {
                ans = Math.max(ans, prefixSum - map.get(rem));
                if(map.get(rem) > prefixSum) {
                    map.put(rem, prefixSum);
                }
            }
            else {
                map.put(rem, prefixSum);
            }
        }
        return ans;
    }
}