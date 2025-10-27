class Solution {
    public String removeDuplicates(String s, int k) {
        Stack<String> st = new Stack<>();
        for(int i = 0; i < s.length(); i++) {
            if(st.size() == 0) {
                st.push(s.charAt(i)+"");
                st.push("1");
                continue;
            }
            String s1 = st.pop();
            if(st.peek().charAt(0) == s.charAt(i)) {
                int x = Integer.parseInt(s1) + 1;
                if(x % k == 0) {
                    st.pop();
                }
                else {
                    st.push((x%k)+"");
                }
            }
            else {
                st.push(s1);
                st.push(s.charAt(i)+"");
                st.push("1");
            }
        }
        StringBuilder str = new StringBuilder();
        while(!st.isEmpty()) {
            String s1 = st.pop();
            int x = Integer.parseInt(s1);
            char c = st.pop().charAt(0);
            for(int i = 0; i < x; i++) {
                str.append(c);
            }
        }
        str.reverse();
        return str.toString();
    }
}