class Solution {
    public int longestValidParentheses(String s) {
        // 0--> '('
        // 1--> ')'
        Stack<Integer> st = new Stack<>();
        char[] ch = s.toCharArray();
        for(int i = 0; i < ch.length; i++) {
            if(ch[i] == '(') {
                st.push(0);
            }
            else {
                if(!st.isEmpty()) {
                    if(st.peek() != 0 && st.peek() != 1) {
                        int x = st.pop();
                        if(!st.isEmpty()) {
                            if(st.peek() == 1) {
                                st.push(x);
                                st.push(1);
                            }
                            else {
                                st.pop();
                                int ans = x + 2;
                                if(!st.isEmpty() && st.peek() != 0 && st.peek() != 1) {
                                    ans += st.pop();
                                }
                                st.push(ans);
                            }
                        }
                        else {
                            st.push(x);
                            st.push(1);
                        }
                    }
                    else if(st.peek() == 0) {
                        st.pop();
                        if(!st.isEmpty() && st.peek() != 0 && st.peek() != 1) {
                            int ans = 2 + st.pop();
                            st.push(ans);
                        }
                        else {
                            st.push(2);
                        }
                    }
                }
                else {
                    st.push(1);
                }
            }
        }
        int ans = 0;
        while(!st.isEmpty()) {
            int x = st.pop();
            if(x != 0 && x != 1) {
                ans = Math.max(ans, x);
            }
        }
        return ans;
    }
}