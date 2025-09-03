class Solution {
    public int findShortestSubArray(int[] nums) {
        HashMap<Integer, Integer> map = new HashMap<>();
        int max = 0;
        for(int i = 0; i < nums.length; i++) {
            map.put(nums[i], map.getOrDefault(nums[i], 0) + 1);
            max = Math.max(map.get(nums[i]), max);
        }
        int ei = 0;
        int si = 0;
        map.clear();
        int cnt = 0;
        int ans = nums.length;
        while(ei < nums.length) {
            map.put(nums[ei], map.getOrDefault(nums[ei], 0) + 1);
            int x = map.get(nums[ei]);
            while(x == max) {
                ans = Math.min(ans, ei - si + 1);
                map.put(nums[si], map.get(nums[si]) - 1);
                x = map.get(nums[ei]);
                si++;
            }
            ei++;
        }
        return ans;
    }
}