class Solution {
    public String removeOuterParentheses(String s) {
        StringBuilder sb = new StringBuilder();
        char[] ch = s.toCharArray();
        int open = 0;
        int close = 0;
        for(int i = 0; i < ch.length; i++) {
            if(ch[i] == '(') {
                open++;
            }
            else {
                close++;
                if(open == close) {
                    ch[i-(open+close-1)] = 'x';
                    ch[i] = 'x';
                    open = 0;
                    close = 0;
                }
            }
        }
        for(int i = 0; i < ch.length; i++) {
            if(ch[i] != 'x') {
                sb.append(ch[i]);
            }
        }
        return sb.toString();
    }
}