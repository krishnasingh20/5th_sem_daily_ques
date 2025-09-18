class Solution {
    public boolean isValid(String s) {
        Stack<Character> st = new Stack<>();
        for(char c:s.toCharArray()) {
            if(c == '(' || c == '{' || c == '[') {
                st.push(c);
            }
            else {
                if(st.isEmpty()) {
                    return false;
                }
                else if(!isCorrect(st.peek(), c)) {
                    return false;
                }
                st.pop();
            }
        }
        return st.isEmpty();
    }
    public boolean isCorrect(char o, char c) {
        if(o == '(' && c == ')') {
            return true;
        }
        if(o == '{' && c == '}') {
            return true;
        } 
        if(o == '[' && c == ']') {
            return true;
        }
        return false;
    }
}