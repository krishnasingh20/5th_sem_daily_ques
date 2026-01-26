class Solution {
    public int[] asteroidCollision(int[] asteroid) {
        int n = asteroid.length;
        Stack<Integer> st = new Stack<>();
        for(int i = 0; i < n; i++) {
            boolean flag = false;
            while(!st.isEmpty() && st.peek() > 0 && asteroid[i] < 0) {
                if(st.peek() == Math.abs(asteroid[i])) {
                    flag = true;
                    st.pop();
                    break;
                }
                else if(st.peek() > Math.abs(asteroid[i])) {
                    flag = true;
                    break;
                }
                st.pop();
            }
            if(!flag) {
                st.push(asteroid[i]);
            }
        }
        int size = st.size();
        int[] ans = new int[size];
        while(!st.isEmpty()) {
            ans[--size] = st.pop();
        }
        return ans;
    }
}