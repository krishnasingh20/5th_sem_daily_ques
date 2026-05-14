class Solution {
    public String removeKdigits(String num, int k) {
        int n = num.length();
        if(n == k) {
            return "0";
        }

        char[] ch = num.toCharArray();
        Stack<Integer> st = new Stack<>();

        for(int i = 0; i < n; i++) {
            while(!st.isEmpty() && k > 0 && ch[st.peek()] > ch[i]) {
                k--;
                ch[st.peek()] = 'x';
                st.pop();
            }
            if(k == 0) {
                break;
            }
            if(st.isEmpty() && ch[i] == '0') {
                continue;
            }
            st.push(i);
        }

        if(k > 0) {
            for(int i = n-1; i >= 0; i--) {
                if(ch[i] != 'x') {
                    ch[i] = 'x';
                    k--;
                }
                if(k == 0) {
                    break;
                }
            }
        }

        StringBuilder sb = new StringBuilder();

        for(int i = 0; i < n; i++) {
            if(ch[i] == 'x' || (sb.length() == 0 && ch[i] == '0')) {
                continue;
            }
            sb.append(ch[i]);
        }

        return sb.length() == 0 ? "0" : sb.toString();
    }
}