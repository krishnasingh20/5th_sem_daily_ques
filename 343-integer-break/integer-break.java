class Solution {
    public int integerBreak(int n) {
        if(n == 2 || n == 3) {
            return n - 1;
        }
        if(n == 5) {
            return 6;
        }
        if(n % 3 == 0) {
            return (int)Math.pow(3, n / 3);
        }
        else {
            int pow = (n / 3);
            int two = n - (3 * pow);
            if(two % 2 == 0) {
                return ((int)Math.pow(3, pow) * two);
            }
            pow -= 1;
            two = n - (3 * pow);
            return ((int)Math.pow(3, pow) * two);
        }
    }
}