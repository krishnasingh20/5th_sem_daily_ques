class Solution {
    public boolean validateStackSequences(int[] pushed, int[] popped) {
        Stack<Integer> st = new Stack<>();
        int i = 0; 
        int j = 0;
        while(i < pushed.length) {
            st.push(pushed[i]);
            while(!st.isEmpty() && j < popped.length && st.peek() == popped[j]) {
                st.pop();
                j++;
            }
            i++;
        }
        while(j < popped.length && !st.isEmpty() && st.peek() == popped[j]) {
            st.pop();
            j++;
        }
        return st.isEmpty();
    }
}