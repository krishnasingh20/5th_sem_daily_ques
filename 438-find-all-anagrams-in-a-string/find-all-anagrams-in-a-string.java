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
        // String pKey = keyGenerate(freq);
        // Arrays.fill(freq, 0);
        int[] freq1 = new int[26];
        int k = p.length();
        int n = s.length();
        for(int i = 0; i < k; i++) {
            freq1[s.charAt(i)-'a']++;
        }
        // String sKey = keyGenerate(freq);
        // if(sKey.equals(pKey)) {
        //     ll.add(0);
        // }
        if(Arrays.equals(freq, freq1)) {
            ll.add(0);
        }
        for(int i = k; i < n; i++) {
            freq1[s.charAt(i)-'a']++;
            freq1[s.charAt(i-k)-'a']--;
            // sKey = keyGenerate(freq);
            // if(sKey.equals(pKey)) {
            //     ll.add(i-k+1);
            // }
            if(Arrays.equals(freq, freq1)) {
                ll.add(i-k+1);
            }
        }
        return ll;
    }
    // public String keyGenerate(int[] freq) {
    //     StringBuilder str = new StringBuilder();
    //     for(int i = 0; i < 26; i++) {
    //         str.append(freq[i]).append('/');
    //     }
    //     return str.toString();
    // }
}