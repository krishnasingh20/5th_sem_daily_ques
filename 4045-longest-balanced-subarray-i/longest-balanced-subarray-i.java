class Solution {
    public int longestBalanced(int[] nums) {
        int ans = 0;
        for(int i = 0; i < nums.length; i++) {
            HashSet<Integer> set = new HashSet<>();
            int even = 0;
            int odd = 0;
            for(int j = i; j < nums.length; j++) {
                if((nums[j] & 1) == 0) {
                    if(!set.contains(nums[j])) {
                        even++;
                    }
                    set.add(nums[j]);
                }
                else {
                    if(!set.contains(nums[j])) {
                        odd++;
                    }
                    set.add(nums[j]);
                }
                if(even == odd) {
                    ans = Math.max(ans, j - i + 1);
                }
            }
        }
        return ans;
    }
}