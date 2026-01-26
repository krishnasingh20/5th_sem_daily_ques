class Solution {
    public String decodeString(String s) {
        StringBuilder sb = new StringBuilder();
        int num = 0;
        Stack<String> st = new Stack<>();
        char[] ch = s.toCharArray();
        int n = ch.length;
        for(int i = 0; i < n;) {
            if(Character.isDigit(ch[i])) {
                num = 0;
                while(i < n && Character.isDigit(ch[i])) {
                    num = num*10 + (ch[i]-'0');
                    i++;
                }
                st.push((num+""));
            }
            else if(ch[i] == '[') {
                st.push("[");
                i++;
            }
            else if(Character.isLowerCase(ch[i])) {
                while(i < n && Character.isLowerCase(ch[i])) {
                    sb.append(ch[i]);
                    i++;
                }
                s = sb.toString();
                sb.setLength(0);
                while(!st.isEmpty() && Character.isLowerCase(st.peek().charAt(0))) {
                    sb.append(st.pop());
                }
                sb.append(s);
                st.push(sb.toString());
                sb.setLength(0);
            }
            else {
                s = st.pop();
                st.pop();
                int repeat = Integer.parseInt(st.pop());
                for(int j = 1; j <= repeat; j++) {
                    sb.append(s);
                }
                s = sb.toString();
                sb.setLength(0);
                while(!st.isEmpty() && Character.isLowerCase(st.peek().charAt(0))) {
                    sb.append(st.pop());
                }
                sb.append(s);
                st.push(sb.toString());
                sb.setLength(0);
                i++;
            }
        }
        return st.pop();
    }
}