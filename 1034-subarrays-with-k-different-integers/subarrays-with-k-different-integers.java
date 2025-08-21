class Solution {
    public int subarraysWithKDistinct(int[] nums, int k) {
        // finding suubarray with exactly k different integer is difficult so what we can do that we can find subarray with less then equal to k diffrent integer and subarrays with less then equal to (k-1) diffrent integer yhen we can do subarray_k - subarray_(k-1) =  subarray with k different integer

        return count(nums, k) - count(nums, k - 1);
    }
    public int count(int[] nums, int k) {
        HashMap<Integer, Integer> map = new HashMap<>();
        int dist = 0;
        int ei = 0;
        int si = 0;
        int ans = 0;
        int n = nums.length;
        while(ei < n) {
            if(map.getOrDefault(nums[ei], 0) == 0) {
                dist++;
            }
            map.put(nums[ei], map.getOrDefault(nums[ei], 0) + 1);
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