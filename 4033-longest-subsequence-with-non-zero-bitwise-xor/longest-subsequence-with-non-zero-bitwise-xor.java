class Solution {
    public int longestSubsequence(int[] nums) {
        int ans = 0;
        int n = nums.length;
        int[] count = new int[31];

        for(int num: nums) {
            for(int bit = 0; bit < 31; bit++) {
                if((num & (1L << bit)) != 0) {
                    count[bit]++;
                }
            }
        }

        for(int i = 0; i < 31; i++) {
            if(count[i] == 0) {
                continue;
            }
            int curr = ((count[i] - 1)/2)*2 + (n - count[i]) + 1;
            ans = Math.max(ans, curr);
        }

        return ans;
    }
}