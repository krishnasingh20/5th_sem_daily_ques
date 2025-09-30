class Solution {
    public List<Integer> findAnagrams(String s, String p) {
        if(p.length() > s.length()) {
            return new ArrayList<>();
        }

        List<Integer> ll = new ArrayList<>();
        int[] freq = new int[26];

        for(char c: p.toCharArray()) {
            freq[c-'a']++;
        }

        int[] freq1 = new int[26];
        int k = p.length();
        int n = s.length();

        for(int i = 0; i < k; i++) {
            freq1[s.charAt(i)-'a']++;
        }

        if(compare(freq, freq1)) {
            ll.add(0);
        }
        
        for(int i = k; i < n; i++) {
            freq1[s.charAt(i)-'a']++;
            freq1[s.charAt(i-k)-'a']--;
            if(compare(freq, freq1)) {
                ll.add(i-k+1);
            }
        }
        return ll;
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