class Solution {
    public int longestSubsequence(int[] nums) {
        int n = nums.length;
        int zero = 0;
        int xor = 0;
        
        for(int num: nums) {
            zero += (num == 0 ? 1 : 0);
            xor ^= num;
        }

        if(xor != 0) {
            return n;
        }
        
        return zero == n ? 0 : n-1;
    }
}