class Solution {
    public List<Boolean> camelMatch(String[] queries, String pattern) {
        int[] freq = new int[26];
        for(int i = 0; i < pattern.length(); i++) {
            if(Character.isUpperCase(pattern.charAt(i))) {
                freq[pattern.charAt(i)-'A']++;
            }
        }
        StringBuilder str = new StringBuilder();
        for(int i = 0; i < 26; i++) {
            str.append(freq[i]+'/');
        }
        String key = str.toString();
        str.setLength(0);
        List<Boolean> ll = new ArrayList<>();
        for(int i = 0; i < queries.length; i++) {
            freq = new int[26];
            for(int j = 0; j < queries[i].length(); j++) {
                if(Character.isUpperCase(queries[i].charAt(j))) {
                    freq[queries[i].charAt(j)-'A']++;
                }
            }
            for(int k = 0; k < 26; k++) {
                str.append(freq[k]+'/');
            }
            String key1 = str.toString();
            str.setLength(0);
            if(key1.equals(key) == false) {
                ll.add(false);
                continue;
            }
            int j = 0;
            int k = 0;
            while(j < queries[i].length() && k < pattern.length()) {
                if(pattern.charAt(k) == queries[i].charAt(j)) {
                    k++;
                }
                j++;
            }
            if(k == pattern.length()) {
                ll.add(true);
            }
            else {
                ll.add(false);
            }
        }
        return ll;
    }
}