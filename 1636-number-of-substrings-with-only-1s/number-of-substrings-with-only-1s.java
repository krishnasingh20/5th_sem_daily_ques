class Solution {
    public int numSub(String s) {
        long ans = 0;
        int count = 0;
        for(char c: s.toCharArray()) {
            if(c == '0') {
                count = 0;
            }
            else {
                count++;
                ans += count;
            }
        }
        return (int)(ans % 1000000007);
    }
}