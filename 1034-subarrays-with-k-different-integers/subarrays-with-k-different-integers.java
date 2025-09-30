class Solution {
    public int subarraysWithKDistinct(int[] nums, int k) {
        // optimize approach
        return count(nums, k) - count(nums, k-1);
    }
    public int count(int[] nums, int k) {
        HashMap<Integer, Integer> map = new HashMap<>();
        int ei = 0;
        int si = 0;
        int dist = 0;
        int ans = 0;
        int n = nums.length;
        while(ei < n) {
            map.put(nums[ei], map.getOrDefault(nums[ei], 0)+1);
            if(map.get(nums[ei]) == 1) {
                dist++;
            }
            while(dist > k) {
                map.put(nums[si], map.get(nums[si]) - 1);
                if(map.get(nums[si]) == 0) {
                    dist--;
                }
                si++;
            }
            ans += (ei - si + 1);
            ei++;
        }
        return ans;
    }
}