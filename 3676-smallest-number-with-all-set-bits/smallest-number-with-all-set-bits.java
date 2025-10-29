class Solution {
    public int smallestNumber(int n) {
        String s = Integer.toBinaryString(n);
        int ans = 0;
        int a = 0;
        for(int i = 0; i < s.length(); i++) {
            ans = ans + (int)Math.pow(2, a);
            a++;
        }
        return ans;
    }
}