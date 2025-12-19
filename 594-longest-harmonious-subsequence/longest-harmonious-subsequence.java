class Solution {
    public int findLHS(int[] nums) {
        HashMap<Long, Integer> map = new HashMap<>();
        for(int num: nums) {
            map.put((long)num, map.getOrDefault((long)num,0)+1);
        }
        int ans = 0;
        for(int i = 0; i < nums.length; i++) {
            long num = (long)nums[i];
            if(map.containsKey(num-1)) {
                ans = Math.max(ans, map.get(num)+map.get(num-1));
            }
            if(map.containsKey(num+1)) {
                ans = Math.max(ans, map.get(num)+map.get(num+1));
            }
        }
        return ans;
    }
}