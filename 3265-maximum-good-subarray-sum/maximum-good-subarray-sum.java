class Solution {
    public long maximumSubarraySum(int[] nums, int k) {
        int n = nums.length;
        long[] prefix = new long[n+1];
        for(int i = 0; i < n; i++) {
            prefix[i+1] = prefix[i] + nums[i];
        }
        HashMap<Integer, Integer> map = new HashMap<>();
        long ans = Long.MIN_VALUE;
        for(int i = 0; i < n; i++) {
            int a = nums[i] - k;
            int b = nums[i] + k;
            if(map.containsKey(a)) {
                int idx = map.get(a);
                ans = Math.max(ans, prefix[i+1] - prefix[idx]);
            }
            if(map.containsKey(b)) {
                int idx = map.get(b);
                ans = Math.max(ans, prefix[i+1] - prefix[idx]);
            }
            if(map.containsKey(nums[i])) {
                int idx = map.get(nums[i]);
                if(prefix[idx] > prefix[i]) {
                    map.put(nums[i], i);
                }
            }
            else {
                map.put(nums[i], i);
            }
        }
        return ans == Long.MIN_VALUE?0:ans;
    }
}