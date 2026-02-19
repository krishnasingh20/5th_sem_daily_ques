class Solution {
public:
    bool isValid(string s) {
        stack<char> st;
        for(int i = 0; i < s.length(); i++) {
            if(s[i] == '(' || s[i] == '[' || s[i] == '{') {
                st.push(s[i]);
            }
            else {
                if(st.empty() || !valid(st.top(), s[i])) {
                    return false;
                }
                st.pop();
            }
        }
        return st.empty();
    }
    bool valid(char o, char c) {
        return (o == '(' && c == ')') || (o == '[' && c == ']') || (o == '{' && c == '}');
    }
};