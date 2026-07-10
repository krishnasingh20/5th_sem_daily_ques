class Solution {
    public long beautifulSubarrays(int[] nums) {

        int n = nums.length;

        HashMap<Integer, Integer> map = new HashMap<>();
        map.put(0, 1);

        int curr = 0;
        long ans = 0;

        for(int i = 0; i < n; i++) {
            curr = curr ^ nums[i];
            int val = map.getOrDefault(curr, 0);
            map.put(curr, val+1);
            ans += val;
        }

        return ans;
    }
}