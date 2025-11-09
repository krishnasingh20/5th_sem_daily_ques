class Solution {
    public int countMajoritySubarrays(int[] nums, int target) {
        boolean flag = true;
        for(int i = 0; i < nums.length; i++) {
            if(nums[i] == target) {
                nums[i] = 1;
                flag = false;
            }
            else {
                nums[i] = -1;
            }
            if(i > 0) {
                nums[i] = nums[i]+nums[i-1];
            }
        }
        if(flag) {
            return 0;
        }
        long ans = 0;
        TreeMap<Integer, Long> map = new TreeMap<>();
        map.put(0, (long)1);
        for(int i = 0; i < nums.length; i++) {
            int x = nums[i];
            for(int key: map.keySet()) {
                if(key >= x) {
                    break;
                }
                ans += (map.get(key));
            }
            map.put(x, map.getOrDefault(x, 0L)+1L);
        }
        return (int)ans;
    }
}