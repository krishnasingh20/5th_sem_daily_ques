class Solution {
    public int distinctPoints(String s, int k) {
        char[] ch = s.toCharArray();
        long x = 0;
        long y = 0;
        for(char c: ch) {
            if(c == 'U') {
                y += 1;
            }
            else if(c == 'D') {
                y -= 1;
            }
            else if(c == 'L') {
                x -= 1;
            }
            else {
                x += 1;
            }
        }
        Set<String> set = new HashSet<>();
        for(int i = 0; i < k; i++) {
            if(ch[i] == 'U') {
                y -= 1;
            }
            else if(ch[i] == 'D') {
                y += 1;
            }
            else if(ch[i] == 'L') {
                x += 1;
            }
            else {
                x -= 1;
            }
        }
        set.add(x+" "+y);
        for(int i = k; i < ch.length; i++) {
            //grow
            if(ch[i] == 'U') {
                y -= 1;
            }
            else if(ch[i] == 'D') {
                y += 1;
            }
            else if(ch[i] == 'L') {
                x += 1;
            }
            else {
                x -= 1;
            }
            //shrink
            if(ch[i-k] == 'U') {
                y += 1;
            }
            else if(ch[i-k] == 'D') {
                y -= 1;
            }
            else if(ch[i-k] == 'L') {
                x -= 1;
            }
            else {
                x += 1;
            }
            set.add(x+" "+y);
        }
        return set.size();
    }
}