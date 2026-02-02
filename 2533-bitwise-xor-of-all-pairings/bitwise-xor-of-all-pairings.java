class Solution {
    public int xorAllNums(int[] nums1, int[] nums2) {
        int n = nums1.length;
        int m = nums2.length;
        if((n & 1) == 0 && (m & 1) == 0) {
            return 0;
        }
        else if((n & 1) == 0) {
            return allXOR(nums1);
        }
        else if((m & 1) == 0) {
            return allXOR(nums2);
        }
        else {
            return allXOR(nums1)^allXOR(nums2);
        }
    }
    private int allXOR(int[] arr) {
        int xor = 0;
        for(int a: arr) {
            xor ^= a;
        }
        return xor;
    }
}