class Solution {
    public int longestBalanced(int[] nums) {
        HashSet<Integer> set = new HashSet<>();
        int ans = 0;
        int n = nums.length;
        int even = 0;
        int odd = 0;
        for(int i = 0; i < n; i++) {
            for(int j = i; j < n; j++) {
                if((nums[j] & 1) == 1) {
                    if(!set.contains(nums[j])) {
                        odd++;
                    }
                }else {
                    if(!set.contains(nums[j])) {
                        even++;
                    }
                }
                set.add(nums[j]);
                if(even == odd) {
                    ans = Math.max(ans, j-i+1);
                }
            }
            even = 0;
            odd = 0;
            set.clear();
        }
        return ans;
    }
}