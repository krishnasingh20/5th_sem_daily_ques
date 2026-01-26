class Solution {
    public int longestValidParentheses(String s) {
        int ans = 0;
        Stack<Integer> st = new Stack<>();
        char[] ch = s.toCharArray();
        int n = ch.length;
        for(int i = 0; i < n; i++) {
            if(ch[i] == '(') {
                st.push(1);
            }
            else {
                if(!st.isEmpty()) {
                    if(st.peek() == 1) {
                        st.pop();
                        if(!st.isEmpty() && st.peek() < 0) {
                            int x = st.pop();
                            ans = Math.max(ans, Math.abs(x)+2);
                            st.push((x-2));
                            continue;
                        }
                        st.push(-2);
                        ans = Math.max(ans, 2);
                        continue;
                    }
                    else if(st.peek() < 0) {
                        int x = st.pop();
                        if(!st.isEmpty() && st.peek() == 1) {
                            st.pop();
                            x -= 2;
                            if(!st.isEmpty() && st.peek() < 0) {
                                x += st.pop();
                            }
                            ans = Math.max(ans, Math.abs(x));
                            st.push(x);
                            continue;
                        }
                    }
                }
                st.push(2);
            }
        }
        return ans;
    }
}