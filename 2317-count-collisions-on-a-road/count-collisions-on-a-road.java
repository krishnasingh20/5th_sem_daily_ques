class Solution {
    public int countCollisions(String directions) {
        Stack<Character> st = new Stack<>();
        int ans = 0;
        for(char c: directions.toCharArray()) {
            if(c == 'S') {
                while(!st.isEmpty() && st.peek() == 'R') {
                    ans++;
                    st.pop();
                }
                st.push('S');
            }
            else if(c == 'L') {
                if(!st.isEmpty()) {
                    if(st.peek() == 'R') {
                        ans += 2;
                        st.pop();
                        while(!st.isEmpty() && st.peek() == 'R') {
                            ans++;
                            st.pop();
                        }
                        st.push('S');
                    }
                    else {
                        ans++;
                    }
                }
            }
            else {
                st.push('R');
            }
        }
        return ans;
    }
}