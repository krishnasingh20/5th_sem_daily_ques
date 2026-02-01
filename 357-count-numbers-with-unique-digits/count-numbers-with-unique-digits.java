class Solution {
    public int countNumbersWithUniqueDigits(int n) {
        int num = (int)Math.pow(10, n)-1;
        return count(String.valueOf(num), 0, 1, 1, 0, 0);
    }
    private int count(String s, int i, int t, int lz, int r, int mask) {
        if(i == s.length()) {
            if(r == 0) {
                return 1;
            }
            return 0;
        }
        int lb = 0;
        int ub = t==1?(s.charAt(i)-'0'):9;
        int ans = 0;
        for(int digit = lb; digit <= ub; digit++) {
            int newTight = (t==1 && digit==ub)?1:0;
            int newLz = (lz==1 && digit==0)?1:0;
            int newR = r;
            if((mask & (1<<digit)) != 0) {
                newR = 1;
            }
            int newMask = mask;
            if(digit == 0 && lz == 0) {
                newMask = mask | (1<<digit);
            }
            else if(digit > 0) {
                newMask = mask | (1<<digit);
            }
            ans += count(s, i+1, newTight, newLz, newR, newMask);
        }
        return ans;
    }
}