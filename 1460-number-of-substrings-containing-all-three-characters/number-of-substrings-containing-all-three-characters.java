class Solution {
    public int numberOfSubstrings(String s) {
        int a = 0;
        int b = 0;
        int c = 0;
        int n = s.length();
        int count = 0;
        int si = 0;
        int ei = 0;

        while(ei < n) {
            char c1 = s.charAt(ei);
            if(c1 == 'a') {
                a++;
            }
            else if(c1 == 'b') {
                b++;
            }
            else {
                c++;
            }

            while(a > 0 && b > 0 && c > 0) {
                count += (n - ei);
                if(s.charAt(si) == 'a') {
                    a--;
                }
                else if(s.charAt(si) == 'b') {
                    b--;
                }
                else {
                    c--;
                }
                si++;
            }
            ei++;
        }

        return count;
    }
}