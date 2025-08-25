class Solution {
    public boolean checkSubarraySum(int[] nums, int k) {
        int n = nums.length;
        long sum = 0;
        for(int i = 0; i < n; i++) {
            int prev = nums[i];
            nums[i] = (int)((sum+nums[i]) % k);
            sum += prev;
        }
        HashMap<Integer, Integer> map = new HashMap<>();
        for(int i = 0; i < n; i++) {
            if(nums[i] == 0 && i > 0) {
                return true;
            }
            if(map.containsKey(nums[i])) {
                if(i - map.get(nums[i]) > 1) {
                    return true;
                }
            }
            else {
                map.put(nums[i], i);
            }
        }
        return false;
    }
}