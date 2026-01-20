class Solution {
    public int calPoints(String[] operations) {
        Stack<Integer> st = new Stack<>();
        int sum = 0;
        for(int i = 0; i < operations.length; i++) {
            if(operations[i].charAt(0) == 'C') {
                st.pop();
            }else if(operations[i].charAt(0) == 'D') {
                st.push(2 * st.peek());
            }else if(operations[i].charAt(0) == '+') {
                int a = st.pop();
                int b = st.pop();
                int c = a + b;
                st.push(b);
                st.push(a);
                st.push(c);
            }else{
                st.push(Integer.parseInt(operations[i]));
            }
        }
        while(!st.isEmpty()) {
            sum += st.pop();
        }
        return sum;
    }
}