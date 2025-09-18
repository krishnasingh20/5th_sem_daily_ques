class Solution {
    public boolean backspaceCompare(String s, String t) {
        Stack<Character> st = new Stack<>();
        for(char c: s.toCharArray()) {
            if(c == '#') {
                if(!st.isEmpty()) {
                    st.pop();
                }
            }
            else {
                st.push(c);
            }
        }
        StringBuilder str = new StringBuilder();
        while(!st.isEmpty()) {
            str.append(st.pop());
        }
        s = str.toString();
        str.setLength(0);
        for(char c: t.toCharArray()) {
            if(c == '#') {
                if(!st.isEmpty()) {
                    st.pop();
                }
            }
            else {
                st.push(c);
            }
        }
        while(!st.isEmpty()) {
            str.append(st.pop());
        }
        return s.equals(str.toString());
    }
}