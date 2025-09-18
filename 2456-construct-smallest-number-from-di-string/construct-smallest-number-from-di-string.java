class Solution {
    public String smallestNumber(String pattern) {
        char[] ch = new char[pattern.length()+1];
        Stack<Integer> st = new Stack<>();
        int count = 1;
        for(int i = 0; i <= pattern.length(); i++) {
            if(i == pattern.length() || pattern.charAt(i) == 'I') {
                ch[i] = (char)(count+'0');
                count++;
                while(!st.isEmpty()) {
                    ch[st.pop()] = (char)(count+'0');
                    count++;
                }
            }
            else {
                st.push(i);
            }
        }
        return new String(ch);
    }
}