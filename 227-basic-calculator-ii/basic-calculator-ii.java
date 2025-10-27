class Solution {
    public int calculate(String s) {
        Stack<Integer> st = new Stack<>();
        int i = 0;
        boolean plus = false;
        boolean neg = false;
        boolean mult = false;
        boolean div = false;
        while(i < s.length()) {
            if(s.charAt(i) == ' ') {
                i++;
                continue;
            }
            else if(Character.isDigit(s.charAt(i))) {
                int val = 0;
                while(i < s.length() && Character.isDigit(s.charAt(i))) {
                    val = (val * 10) + (s.charAt(i)-'0');
                    i++;
                }
                if(plus) {
                    st.push(val);
                    plus = false;
                }
                else if(neg) {
                    st.push(-1*val);
                    neg = false;
                }
                else if(mult) {
                    int x = st.pop();
                    st.push(x*val);
                    mult = false;
                }
                else if(div){
                    int x = st.pop();
                    st.push((x/val));
                    div = false;
                }
                else {
                    st.push(val);
                }
            }
            else {
                if(s.charAt(i) == '+') {
                    plus = true;
                }
                else if(s.charAt(i) == '-') {
                    neg = true;
                }
                else if(s.charAt(i) == '*') {
                    mult = true;
                }
                else {
                    div = true;
                }
                i++;
            }
        }
        int ans = 0;
        while(!st.isEmpty()) {
            ans += st.pop();
        }
        return ans;
    }
}