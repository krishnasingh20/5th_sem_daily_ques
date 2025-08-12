class Solution {
    public boolean isValid(String s) {
        Stack<Character> st = new Stack<>();
        for(char ch: s.toCharArray()) {
            if(ch == '(' || ch == '[' || ch == '{') {
                st.push(ch);
            }
            else {
                if(st.isEmpty() || !istrue(st.peek(), ch)) {
                    return false;
                }
                else {
                    st.pop();
                }
            }
        }
        return st.isEmpty();
    }
    public boolean istrue(char o, char c) {
        return (o == '(' && c == ')') || (o == '{' && c == '}') || (o == '[' && c == ']');
    }
}