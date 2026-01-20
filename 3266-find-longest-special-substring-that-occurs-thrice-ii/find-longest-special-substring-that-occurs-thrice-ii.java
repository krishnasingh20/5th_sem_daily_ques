class Solution {
    public int maximumLength(String s) {
        int[][] count = new int[26][3];
        int c1 = 1;
        int n = s.length();
        for(int i = 1; i < n; i++) {
            if(s.charAt(i) != s.charAt(i-1)) {
                int c = s.charAt(i-1)-'a';
                if(c1 > count[c][2]) {
                    count[c][0] = count[c][1];
                    count[c][1] = count[c][2];
                    count[c][2] = c1;
                }
                else if(c1 > count[c][1]) {
                    count[c][0] = count[c][1];
                    count[c][1] = c1;
                }
                else if(c1 > count[c][0]) {
                    count[c][0] = c1;
                }
                c1 = 0;
            }
            c1++;
        }
        int c = s.charAt(n-1)-'a';
        if(c1 > count[c][2]) {
            count[c][0] = count[c][1];
            count[c][1] = count[c][2];
            count[c][2] = c1;
        }
        else if(c1 > count[c][1]) {
            count[c][0] = count[c][1];
            count[c][1] = c1;
        }
        else if(c1 > count[c][0]) {
            count[c][0] = c1;
        }
        int ans = Integer.MIN_VALUE;
        for(int i = 0; i < 26; i++) {
            ans = Math.max(ans, Math.min(Math.min(count[i][2], count[i][1]), count[i][0]));
            ans = Math.max(ans, Math.min(count[i][2]-1, count[i][1]));
            ans = Math.max(ans, count[i][2]-2);
        }
        return ans <= 0?-1:ans;
    }
}