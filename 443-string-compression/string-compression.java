class Solution {
    public int compress(char[] ch) {
        int idx = 0;
        int c = 1;
        for(int i = 1; i < ch.length; i++) {
            if(ch[i] != ch[i-1]) {
                ch[idx++] = ch[i-1];
                if(c > 1) {
                    String s = Integer.toString(c);
                    for(int j = 0; j < s.length(); j++) {
                        ch[idx++] = s.charAt(j); 
                    }
                    c = 1;
                }
                continue;
            }
            c++;
        }
        ch[idx++] = ch[ch.length-1];
        if(c > 1) {
            String s = Integer.toString(c);
            for(int j = 0; j < s.length(); j++) {
                ch[idx++] = s.charAt(j); 
            }
        }
        return idx;
    }
}