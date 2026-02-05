class Trie {

    class Node {
        char ch;
        boolean isTerminal;
        Node[] child;
        public Node(char ch) {
            this.ch = ch;
            child = new Node[26];
        }
    }

    private Node root;

    public Trie() {
        root = new Node('*');
    }

    public void insert(String word) {
        Node curr = root;
        for(int i = 0; i < word.length(); i++) {
            char ch = word.charAt(i);
            if(curr.child[ch-'a'] != null) {
                curr = curr.child[ch-'a'];
            }
            else {
                Node nn = new Node(ch);
                curr.child[ch-'a'] = nn;
                curr = nn;
            }
        }
        curr.isTerminal = true;
    }

    public boolean search(String word) {
        Node curr = root;
        for(int i = 0; i < word.length(); i++) {
            char ch = word.charAt(i);
            if(curr.child[ch-'a'] == null) {
                return false;
            }
            curr = curr.child[ch-'a'];
        }
        return curr.isTerminal;
    }

    public boolean startsWith(String prefix) {
        Node curr = root;
        for(int i = 0; i < prefix.length(); i++) {
            char ch = prefix.charAt(i);
            if(curr.child[ch-'a'] == null) {
                return false;
            }
            curr = curr.child[ch-'a'];
        }
        return true;
    }
}

/**
 * Your Trie object will be instantiated and called as such:
 * Trie obj = new Trie();
 * obj.insert(word);
 * boolean param_2 = obj.search(word);
 * boolean param_3 = obj.startsWith(prefix);
 */