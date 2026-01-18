class Solution {
    public String lexSmallestAfterDeletion(String s) {
        int[] freq = new int[26];
        char[] ch = s.toCharArray();
        int n = ch.length;
        for(int i = 0; i < n; i++) {
            freq[ch[i]-'a']++;
        }
        Stack<Integer> st = new Stack<>();
        for(int i = 0; i < n; i++) {
            while(!st.isEmpty() && ch[st.peek()] > ch[i] && freq[ch[st.peek()]-'a'] > 1) {
                int idx = st.pop();
                freq[ch[idx]-'a']--;
                ch[idx] = '0';
            }
            st.push(i);
        }
        while(!st.isEmpty() && freq[ch[st.peek()]-'a'] > 1) {
            int idx = st.pop();
            freq[ch[idx]-'a']--;
            ch[idx] = '0';
        }
        StringBuilder sb = new StringBuilder();
        while(!st.isEmpty()) {
            sb.append(ch[st.pop()]);
        }
        sb.reverse();
        return sb.toString();
    }
}