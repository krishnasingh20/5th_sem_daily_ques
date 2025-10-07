class Solution {
    public int evalRPN(String[] tokens) {
        Stack<Integer> st = new Stack<>();
        for(int i = 0; i < tokens.length; i++) {
            char c = tokens[i].charAt(0);
            if(tokens[i].length() == 1 && (c == '+' || c == '-' || c == '*' || c == '/')) {
                int a = st.pop();
                int b = st.pop();
                if(c == '+') {
                    st.push((a+b));
                }
                else if(c == '-') {
                    st.push((b-a));
                }
                else if(c == '*') {
                    st.push((b*a));
                }
                else {
                    st.push((b/a));
                }
            }
            else {
                st.push(Integer.parseInt(tokens[i]));
            }
        }
        return st.pop();
    }
}