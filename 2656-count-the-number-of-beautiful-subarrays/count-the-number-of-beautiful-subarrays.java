class Solution {
    public long beautifulSubarrays(int[] nums) {

        int n = nums.length;
        
        HashMap<Integer, Integer> map = new HashMap<>();
        map.put(0, 1);

        int curr = 0;
        long ans = 0;

        for(int i = 0; i < n; i++) {

            for(int j = 0; j <= 20; j++) {

                if((nums[i] & (1 << j)) != 0) {
                    curr = curr ^ (1 << j);
                }
            }

            int val = map.getOrDefault(curr, 0);
            map.put(curr, val+1);
            ans += val;
        }

        return ans;
    }
}