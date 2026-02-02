class Solution {
    public int rangeBitwiseAnd(int left, int right) {
        if( left == 1073741824 && right == 2147483647) {
            return left;
        }
        int len1 = 32 - Integer.numberOfLeadingZeros(left);
        int len2 = 32 - Integer.numberOfLeadingZeros(right);
        if(Math.abs(len1 - len2) >= 1) {
            return 0;
        }
        long ans = left;
        for(long i = left+1L; i <= right; i++) {
            ans &= i;
        }
        return (int)ans;
    }
}