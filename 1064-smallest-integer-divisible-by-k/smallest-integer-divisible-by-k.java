class Solution {
    public int smallestRepunitDivByK(int k) {
        int rem = 0;
        int c = 1;
        while(c <= k) {
            rem = (rem * 10 + 1) % k;
            if(rem == 0) {
                return c;
            }
            c++;
        }
        return -1;
    }
}