class Solution {
    public int maxNumberOfBalloons(String s) {
        int a = 0;
        int b = 0;
        int l = 0;
        int o = 0;
        int n = 0;

        for(int i = 0; i < s.length(); i++) {
            if(s.charAt(i) == 'b') {
                b++;
            }
            else if(s.charAt(i) == 'a') {
                a++;
            }
            else if(s.charAt(i) == 'l') {
                l++;
            }
            else if(s.charAt(i) == 'o') {
                o++;
            } 
            else if(s.charAt(i) == 'n') {
                n++;
            }
        }

        int ans = Math.min(a, Math.min(b, Math.min(l/2, Math.min(o/2, n))));

        return ans;
    }
}