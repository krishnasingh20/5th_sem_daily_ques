class Solution {
    public int[] asteroidCollision(int[] asteroids) {
        Stack<Integer> st = new Stack<>();
        for(int i = 0; i < asteroids.length; i++) {
            boolean flag = false;
            while(!st.isEmpty() && st.peek() > 0 && asteroids[i] < 0) {
                if(Math.abs(asteroids[i]) == st.peek()) {
                    st.pop();
                    flag = true;
                    break;
                }
                else if(Math.abs(asteroids[i]) < st.peek()) {
                    flag = true;
                    break;
                }
                else {
                    st.pop();
                }
            }
            if(!flag) {
                st.push(asteroids[i]);
            }
        }
        int[] ans = new int[st.size()];
        int idx = ans.length - 1;
        while(!st.isEmpty()) {
            ans[idx--] = st.pop();
        }
        return ans;
    }
}