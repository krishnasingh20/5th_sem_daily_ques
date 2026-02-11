class Solution {
    public int maximumXOR(int[] nums) {
        int ans = 0;
        for(int num: nums) {
            for(int i = 0; i <= 30; i++) {
                int mask = (1<<i);
                if((num & mask) != 0) {
                    ans |= mask;
                }
            }
        }
        return ans;
    }
}