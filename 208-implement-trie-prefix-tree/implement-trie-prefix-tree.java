class Trie {

    class Node {
        boolean isTerminal;
        Node[] child;
        Node() {
            child = new Node[26];
        }
    }

    Node root;

    public Trie() {
        root = new Node();
    }
    
    public void insert(String word) {
        Node curr = root;
        
        for(int i = 0; i < word.length(); i++) {
            int x = word.charAt(i)-'a';
            if(curr.child[x] == null) {
                curr.child[x] = new Node();
            }
            curr = curr.child[x];
        }

        curr.isTerminal = true;
    }
    
    public boolean search(String word) {
        Node curr = root;

        for(int i = 0; i < word.length(); i++) {
            int x = word.charAt(i)-'a';
            if(curr.child[x] == null) {
                return false;
            }
            curr = curr.child[x];
        }

        return curr.isTerminal;
    }
    
    public boolean startsWith(String prefix) {
        Node curr = root;
        for(int i = 0; i < prefix.length(); i++) {
            int x = prefix.charAt(i)-'a';
            if(curr.child[x] == null) {
                return false;
            }
            curr = curr.child[x];
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