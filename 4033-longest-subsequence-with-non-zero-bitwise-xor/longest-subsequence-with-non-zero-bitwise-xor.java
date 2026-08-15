class Solution {
    public int longestSubsequence(int[] nums) {
        int ans = 0;

        for(int bit = 0; bit < 31; bit++) {
            int one = 0;
            int zero = 0;

            for(int num: nums) {
                if((num & (1L << bit)) != 0) {
                    one++;
                }
                else {
                    zero++;
                }
            }

            if(one > 0) {
                int curr = ((one - 1)/2)*2 + zero + 1;
                ans = Math.max(ans, curr);
            }
        }

        return ans;
    }
}