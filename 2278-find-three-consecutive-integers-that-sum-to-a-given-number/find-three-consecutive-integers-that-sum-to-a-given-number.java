class Solution {
    public long[] sumOfThree(long num) {
        long x = (num - 3) / 3;
        if(3*x + 3 != num) {
            return new long[]{};
        }
        return new long[]{x, x+1, x+2};
    }
}