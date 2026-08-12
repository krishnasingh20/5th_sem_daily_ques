class Solution {
    public int maxSubarrayLength(int[] nums, int k) {
        int n = nums.length;
        HashMap<Integer, Integer> map = new HashMap<>();
        int ans = 0;
        int si = 0;

        for(int ei = 0; ei < n; ei++) {
            map.put(nums[ei], map.getOrDefault(nums[ei], 0)+1);
            while(map.get(nums[ei]) > k) {
                map.put(nums[si], map.get(nums[si])-1);
                si++;
            }
            ans = Math.max(ans, (ei - si + 1));
        }

        return ans;
    }
}