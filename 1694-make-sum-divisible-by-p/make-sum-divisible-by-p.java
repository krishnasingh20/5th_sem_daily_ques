class Solution {
    public int minSubarray(int[] nums, int p) {
        long sum = 0;
        for(int num: nums) {
            sum += num;
        }
        if((sum % p) == 0) {
            return 0;
        }
        HashMap<Integer, Integer> map = new HashMap<>();
        map.put(0, -1);
        long prefixSum = 0;
        int rem = (int)(sum % p);
        int ans = Integer.MAX_VALUE;
        for(int i = 0; i < nums.length; i++) {
            prefixSum += nums[i];
            int req = (int)((prefixSum - rem + p) % p);
            if(map.containsKey(req)) {
                ans = Math.min(ans, i - map.get(req));
            }
            map.put((int)(prefixSum % p), i);
        }
        if(ans == Integer.MAX_VALUE || ans == nums.length) {
            return -1;
        }
        return ans;
    }
}