class MagicDictionary {
    class Dict {
        boolean isTerminal;
        Dict[] child = new Dict[26];
    }
    private Dict root;
    public MagicDictionary() {
        root = new Dict();
    }
    
    public void buildDict(String[] dictionary) {
        for(String s: dictionary) {
            Dict curr = root;
            for(char c: s.toCharArray()) {
                if(curr.child[c-'a'] == null) {
                    curr.child[c-'a'] = new Dict();
                }
                curr = curr.child[c-'a'];
            }
            curr.isTerminal = true;
        }
    }
    
    public boolean search(String searchWord) {
        return dfs(searchWord, root, 0, 0);
    }
    private boolean dfs(String s, Dict curr, int i, int change) {
        if(i == s.length()) {
            if(curr.isTerminal == true && change == 1) {
                return true;
            }
            return false;
        }
        char c = s.charAt(i);
        if(curr.child[c-'a'] != null) {
            if(dfs(s, curr.child[c-'a'], i+1, change)) {
                return true;
            }
        }
        if(change == 0) {
            for(int j = 0; j < 26; j++) {
                if(curr.child[j] == null || j == c-'a') {
                    continue;
                }
                if(dfs(s, curr.child[j], i+1, change+1)) {
                    return true;
                }
            }
        }
        return false;
    }
}

/**
 * Your MagicDictionary object will be instantiated and called as such:
 * MagicDictionary obj = new MagicDictionary();
 * obj.buildDict(dictionary);
 * boolean param_2 = obj.search(searchWord);
 */