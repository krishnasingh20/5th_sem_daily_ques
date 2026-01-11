class Solution {
    public int minLength(int[] nums, int k) {
        HashMap<Integer, Integer> map = new HashMap<>();
        int ans = Integer.MAX_VALUE;
        int n = nums.length;
        long sum = 0;
        for(int ei = 0, si = 0; ei < n; ei++) {
            if(map.getOrDefault(nums[ei], 0) == 0) {
                sum += nums[ei];
            }
            map.put(nums[ei], map.getOrDefault(nums[ei], 0)+1);
            while(sum >= k) {
                ans = Math.min(ans, ei-si+1);
                map.put(nums[si], map.get(nums[si])-1);
                if(map.get(nums[si]) == 0) {
                    sum -= nums[si];
                }
                si++;
            }
        }
        return ans==Integer.MAX_VALUE?-1:ans;
    }
}