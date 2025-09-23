class Solution {
    public long maximumSubarraySum(int[] nums, int k) {
        HashMap<Integer, Integer> map = new HashMap<>();
        long ans = 0;
        int count = 0;
        long sum = 0;
        for(int i = 0; i < k; i++) {
            sum += nums[i];
            map.put(nums[i], map.getOrDefault(nums[i], 0) + 1);
            if(map.get(nums[i]) == 2) {
                count++;
            }
        }
        if(count == 0) {
            ans = Math.max(ans, sum);
        }
        for(int i = k; i < nums.length; i++) {
            sum += nums[i];
            map.put(nums[i], map.getOrDefault(nums[i], 0) + 1);
            if(map.get(nums[i]) == 2) {
                count++;
            }
            map.put(nums[i-k], map.get(nums[i-k]) - 1);
            sum -= nums[i-k];
            if(map.get(nums[i-k]) == 1) {
                count--;
            }
            if(count == 0) {
                ans = Math.max(ans, sum);
            }
        }
        return ans;
    }
}