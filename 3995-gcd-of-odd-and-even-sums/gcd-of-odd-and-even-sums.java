class Solution {
    public int gcdOfOddEvenSums(int n) {
        int sumOdd = n * n;
        int sumEven = n * (n + 1);
        return n; //highest factor is n that is common in both the number
    }
    private int GCD(int a, int b) {
        return (b == 0 ? a : GCD(b, a % b));
    }
}