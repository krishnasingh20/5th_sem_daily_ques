class Solution {
    public List<String> findAndReplacePattern(String[] words, String pattern) {
        List<String> ll = new ArrayList<>();
        for(int i = 0; i < words.length; i++) {
            HashMap<Character, Character> map = new HashMap<>();
            boolean[] flag = new boolean[26];
            boolean take = true;
            for(int j = 0; j < words[i].length(); j++) {
                if(map.containsKey(pattern.charAt(j))) {
                    if(map.get(pattern.charAt(j)) != words[i].charAt(j)) {
                        take = false;
                        break;
                    }
                }
                else {
                    if(flag[words[i].charAt(j)-'a']) {
                        take = false;
                        break;
                    }
                    map.put(pattern.charAt(j), words[i].charAt(j));
                    flag[words[i].charAt(j)-'a'] = true;
                }
            }
            if(take) {
                ll.add(words[i]);
            }
        }
        return ll;
    }
}