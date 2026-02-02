class Solution {
    public int minimizeXor(int num1, int num2) {
        int c = setBit(num2);
        int x = 0;
        for(int i = 30; i >= 0 && c > 0; i--) {
            int mask = 1<<i;
            if((mask & num1) != 0) {
                x += mask;
                c--;
            }
        }
        if(c == 0) {
            return x;
        }
        for(int i = 0; i <= 30 && c > 0; i++) {
            int mask = 1<<i;
            if((mask & num1) == 0) {
                x += mask;
                c--;
            }
        }
        return x;
    }
    private int setBit(int n) {
        int c = 0;
        while(n > 0) {
            c++;
            n = n & (n-1);
        }
        return c;
    }
}