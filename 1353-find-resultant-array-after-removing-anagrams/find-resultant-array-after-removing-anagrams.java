class Solution {
    public List<String> removeAnagrams(String[] words) {
        Stack<String> st = new Stack<>();
        List<String> ans = new ArrayList<>();
        for(int i = 0; i < words.length; i++) {
            if(!st.isEmpty()) {
                String s = st.peek();
                int[] freq1 = new int[26];
                int[] freq2 = new int[26];
                for(char c: s.toCharArray()) {
                    freq1[c-'a']++;
                }
                for(char c:words[i].toCharArray()) {
                    freq2[c-'a']++;
                }
                if(compare(freq1, freq2)) {
                    continue;
                }
            }
            st.push(words[i]);
        }
        while(!st.isEmpty()) {
            ans.add(st.pop());
        }
        Collections.reverse(ans);
        return ans;
    }
    public boolean compare(int[] a, int[] b) {
        for(int i = 0; i < 26; i++) {
            if(a[i] != b[i]) {
                return false;
            }
        }
        return true;
    }
}