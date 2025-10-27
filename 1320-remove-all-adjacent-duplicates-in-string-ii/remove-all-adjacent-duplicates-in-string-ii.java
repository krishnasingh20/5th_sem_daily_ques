class Solution {
    public String removeDuplicates(String s, int k) {
        Stack<Pair> st = new Stack<>();
        for(int i = 0; i < s.length(); i++) {
            if(!st.isEmpty() && st.peek().ch == s.charAt(i)) {
                int x = st.peek().c + 1;
                if(x % k == 0) {
                    st.pop();
                }
                else {
                    st.peek().c = x % k;
                }
            }
            else {
                st.push(new Pair(s.charAt(i), 1));
            }
        }
        StringBuilder str = new StringBuilder();
        while(!st.isEmpty()) {
            Pair p = st.pop();
            int x = p.c;
            char c = p.ch;
            for(int i = 0; i < x; i++) {
                str.append(c);
            }
        }
        str.reverse();
        return str.toString();
    }
    class Pair {
        char ch;
        int c;
        Pair(char ch, int c) {
            this.ch = ch;
            this.c = c;
        }
    }
}