class Solution {
    public String smallestSubsequence(String s) {
        int[] freq = new int[26];
        boolean[] present = new boolean[26];
        char[] ch = s.toCharArray();
        for(char c: ch) {
            freq[c-'a']++;
        }
        Stack<Integer> st = new Stack<>();
        for(int i = 0; i < ch.length; i++) {
            freq[ch[i]-'a']--;
            if(present[ch[i]-'a']) {
                continue;
            }
            while(!st.isEmpty() && ch[st.peek()] > ch[i] && freq[ch[st.peek()]-'a'] > 0) {
                present[ch[st.peek()]-'a'] = false;
                st.pop();
            }
            st.push(i);
            present[ch[i]-'a'] = true;
        }
        StringBuilder sb = new StringBuilder();
        while(!st.isEmpty()) {
            sb.append(ch[st.pop()]);
        }
        return sb.reverse().toString();
    }
}