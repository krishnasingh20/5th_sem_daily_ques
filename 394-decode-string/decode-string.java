class Solution {
    public String decodeString(String s) {
        Stack<String> st = new Stack<>();
        int i = s.length()-1;
        StringBuilder str = new StringBuilder();
        while(i >= 0) {
            if(s.charAt(i) == ']') {
                st.push("]");
                i--;
            }
            else if(s.charAt(i) == '[') {
                st.push("[");
                i--;
            }
            else if(Character.isDigit(s.charAt(i))) {
                int val = 0;
                int a = 1;
                while(i >= 0 && Character.isDigit(s.charAt(i))) {
                    int x = s.charAt(i) - '0';
                    val = val + x*a;
                    a *= 10;
                    i--;
                }
                st.pop();//to remove open bracket
                while(val-- > 0) {
                    str.append(st.peek());
                }
                st.pop();//to remove string that is on top
                st.pop();//to rmove close bracket
                if(!st.isEmpty() && st.peek().charAt(0) != ']') {
                    str.append(st.pop());
                }
                st.push(str.toString());
                str.setLength(0);
            }
            else {
                while(i >= 0 && s.charAt(i) >= 'a' && s.charAt(i) <= 'z') {
                    str.append(s.charAt(i));
                    i--;
                }
                str.reverse();
                if(!st.isEmpty() && st.peek().charAt(0) != ']') {
                    str.append(st.pop());
                }
                st.push(str.toString());
                str.setLength(0);
            }
        }
        return st.pop();
    }
}