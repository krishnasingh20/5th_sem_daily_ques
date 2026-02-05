class Solution {
    class Trie {
        class Node {
            char ch;
            int count;
            boolean isTerminal;
            Node[] child;
            Node(char ch) {
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
                    curr.count++;
                }
                else {
                    Node nn = new Node(ch);
                    curr.child[ch-'a'] = nn;
                    curr = nn;
                    curr.count = 1;
                }
            }
            curr.isTerminal = true;
        }
        public int prefixScore(String word) {
            int score = 0;
            Node curr = root;
            for(int i = 0; i < word.length(); i++) {
                char ch = word.charAt(i);
                curr = curr.child[ch-'a'];
                score += curr.count;
            }
            return score;
        }
    }
    public int[] sumPrefixScores(String[] words) {
        Trie trie = new Trie();
        int[] ans = new int[words.length];
        for(String word: words) {
            trie.insert(word);
        }
        for(int i = 0; i < words.length; i++) {
            ans[i] = trie.prefixScore(words[i]);
        }
        return ans;
    }
}