class Solution {
    public String maxValue(String n, int x) {
        char[] ch = n.toCharArray();
        int idx = ch.length;
        boolean flag = false;
        // negative number case
        if(ch[0] == '-') {
            flag = true;
            for(int i = ch.length - 1; i > 0; i--) {
                if(ch[i]-'0' >  x) {
                    idx = i;
                }
            }
        }
        //positive number case
        else {
            for(int i = ch.length - 1; i >= 0; i--) {
                if(ch[i]-'0' < x) {
                    idx = i;
                }
            }
        }
        StringBuilder sb = new StringBuilder();
        if(idx == ch.length) {
            sb.append(new String(ch));
            sb.append(x+"");
            return sb.toString();
        }
        int i = 0;
        if(flag) {
            sb.append('-');
            i = 1;
        }
        for(;i < ch.length; i++) {
            if(idx == i) {
                sb.append(x+"");
                sb.append(ch[i]);
            }
            else {
                sb.append(ch[i]);
            }
        }
        return sb.toString();
    }
}