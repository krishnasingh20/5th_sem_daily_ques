class Solution {
    public int maximumSum(int[] nums) {
        int ans = Integer.MIN_VALUE;
        Arrays.sort(nums);
        HashMap<Integer, Integer> map = new HashMap<>();
        for(int i = 0; i < nums.length; i++) {
            int sum = 0;
            int x = nums[i];
            while(x > 0) {
                sum += (x % 10);
                x /= 10;
            }
            if(map.getOrDefault(sum, -1) != -1) {
                ans = Math.max(ans, map.get(sum)+nums[i]);
            }
            map.put(sum, nums[i]);
        }
        return ans==Integer.MIN_VALUE?-1:ans;
    }
}