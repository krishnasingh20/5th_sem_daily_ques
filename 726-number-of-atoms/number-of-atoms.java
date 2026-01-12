class Solution {
    public String countOfAtoms(String s) {
        TreeMap<String, Long> map = new TreeMap<>();
        Stack<String> st = new Stack<>();
        StringBuilder sb = new StringBuilder();
        int bracket = 0;
        int i = 0;
        int n = s.length();
        char[] ch = s.toCharArray();
        long digit = 0;
        while(i < n) {
            if(ch[i] >= 'A' && ch[i] <= 'Z') {
                sb.append(ch[i]);
                i++;
                while(i < n && Character.isLowerCase(ch[i])) {
                    sb.append(ch[i]);
                    i++;
                }
                while(i < n && Character.isDigit(ch[i])) {
                    digit = digit*10 + (ch[i]-'0');
                    i++;
                }
                if(digit == 0) {
                    digit++;
                }
                if(bracket > 0) {
                    st.push(sb.toString());
                    st.push(digit+"");
                }
                else {
                    String s1 = sb.toString();
                    map.put(s1, map.getOrDefault(s1, 0L)+digit);
                }
                sb.setLength(0);
                digit = 0;
            }
            else if(ch[i] == '(') {
                bracket++;
                i++;
                st.push("(");
            }
            else {
                bracket--;
                i++;
                while(i < n && Character.isDigit(ch[i])) {
                    digit = digit*10 + (ch[i]-'0');
                    i++;
                }
                if(digit == 0) {
                    digit++;
                }
                while(!st.isEmpty() && st.peek().charAt(0) != '(') {
                    String s1 = st.pop();
                    long d = 1;
                    if(Character.isDigit(s1.charAt(0))) {
                        String s2 = st.pop();
                        d = Long.parseLong(s1);
                        s1 = s2;
                    }
                    if(bracket > 0) {
                        sb.append(s1).append('/').append((d*digit)).append('/');
                    }
                    else {
                        map.put(s1, map.getOrDefault(s1, 0L)+(digit*d));
                    }
                }
                st.pop();
                if(sb.length() != 0) {
                    sb.deleteCharAt(sb.length()-1);
                    String[] arr = sb.toString().split("/");
                    for(String s1: arr) {
                        st.push(s1);
                    }
                    sb.setLength(0);
                }
                digit = 0;
            }
        }
        for(String key: map.keySet()) {
            sb.append(key);
            long val = map.get(key);
            if(val > 1) {
                sb.append(val);
            }
        }
        return sb.toString();
    }
}