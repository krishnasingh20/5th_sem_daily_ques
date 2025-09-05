class Solution {
    public boolean validateStackSequences(int[] pushed, int[] popped) {
        Stack<Integer> st = new Stack<>();
        int j = 0;
        for(int i = 0; i < pushed.length; i++) {
            if(pushed[i] == popped[j]) {
                j++;
            }
            else {
                st.push(pushed[i]);
            }
            while(!st.isEmpty() && j < popped.length && st.peek() == popped[j]) {
                st.pop();
                j++;
            }
        }
        while(!st.isEmpty() && j < popped.length && st.peek() == popped[j]) {
            st.pop();
            j++;
        }
        return st.isEmpty();
    }
}