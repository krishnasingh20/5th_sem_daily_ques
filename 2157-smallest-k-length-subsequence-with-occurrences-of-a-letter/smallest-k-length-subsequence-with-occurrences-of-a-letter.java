class Solution {
    public String smallestSubsequence(String s, int k, char l, int r) {
        char[] ch = s.toCharArray();
        int n = s.length();
        int cnt = 0;
        for(int i = 0; i < n; i++) {
            if(ch[i] == l) {
                cnt++;
            }
        }
        Stack<Character> st = new Stack<>();
        for(int i = 0; i < n; i++) {
            while(!st.isEmpty() && st.peek() > ch[i]) {
                if((st.size()+(n-i)-1) < k || (st.peek() == l && cnt-1 < r)) {
                    break;
                }
                if(st.peek() == l) {
                    cnt--;
                }
                st.pop();
            }
            st.push(ch[i]);
        }
        // System.out.println(cnt);
        while(st.size() > k) {
            if(st.peek() == l && cnt-1 < r) {
                break;
            }
            if(st.peek() == l) {
                cnt--;
            }
            st.pop();
        }
        StringBuilder sb = new StringBuilder();
        for(char c: st) {
            sb.append(c);
        }
        if(sb.length() == k) {
            return sb.toString();
        }
        int x = sb.length()-k;
        for(int i = sb.length()-1; i >= 0; i--) {
            if(sb.charAt(i) != l) {
                sb.deleteCharAt(i);
                x--;
            }
            if(x == 0) {
                break;
            }
        }
        return sb.toString();
    }
}