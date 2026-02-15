class WordDictionary {
    class Dict {
        boolean isTerminal;
        Dict[] child = new Dict[26];
    }
    private Dict root;
    public WordDictionary() {
        root = new Dict();
    }
    
    public void addWord(String word) {
        Dict curr = root;
        for(char c: word.toCharArray()) {
            if(curr.child[c-'a'] == null) {
                curr.child[c-'a'] = new Dict();
            }
            curr = curr.child[c-'a'];
        }
        curr.isTerminal = true;
    }
    
    public boolean search(String word) {
        return dfs(word, root, 0);
    }
    public boolean dfs(String word, Dict curr, int i) {
        if(i == word.length()) {
            if(curr.isTerminal == true) {
                return true;
            }
            return false;
        }
        char c = word.charAt(i);
        if(c != '.') {
            if(curr.child[c-'a'] == null) {
                return false;
            }
            return dfs(word, curr.child[c-'a'], i+1);
        }
        else {
            for(int j = 0; j < 26; j++) {
                if(curr.child[j] == null) {
                    continue;
                }
                if(dfs(word, curr.child[j], i+1)) {
                    return true;
                }
            }
            return false;
        }
    }
}

/**
 * Your WordDictionary object will be instantiated and called as such:
 * WordDictionary obj = new WordDictionary();
 * obj.addWord(word);
 * boolean param_2 = obj.search(word);
 */