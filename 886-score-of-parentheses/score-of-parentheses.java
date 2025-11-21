class Solution {
    public int scoreOfParentheses(String s) {
        int count = 0;
        Stack<String> st = new Stack<>();
        for(char c: s.toCharArray()) {
            if(c == '(') {
                st.push("(");
            }
            else {
                if(st.peek().charAt(0) != '(') {
                    count = Integer.parseInt(st.pop()) * 2;//(())
                }
                else {
                    count++;//()
                }
                st.pop();//remove '(' from peek
                if(!st.isEmpty() && st.peek().charAt(0) != '(') {
                    count += Integer.parseInt(st.pop());//()()
                }
                st.push(count+"");
                count = 0;
            }
        }
        return Integer.parseInt(st.pop());
    }
}