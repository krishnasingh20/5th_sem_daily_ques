class Solution {
    public int longestSubsequence(int[] nums) {
        int xor = 0;
        boolean nonzero = false;
        for(int num: nums) {
            xor = xor^num;
            if(num != 0) {
                nonzero = true;
            }
        }
        if(xor != 0) {
            return nums.length;
        }
        if(!nonzero) {
            return 0;
        }
        return nums.length - 1;
    }
}