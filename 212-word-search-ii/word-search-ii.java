class Solution {
    class Trie {
        class Node {
            char ch;
            String isTerminal;
            Node[] child;
            Node(char ch) {
                this.ch = ch;
                child = new Node[26];
            }
        }
        Node root;
        public Trie() {
            root = new Node('*');
        }
        private void insert(String word) {
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
            curr.isTerminal = word;
        }
        private void search(char[][] board, int i, int j, Node curr) {
            if(i < 0 || j < 0 || i >= board.length || j >= board[0].length || board[i][j] == '*' || curr.child[board[i][j]-'a'] == null) {
                return;
            }
            char ch = board[i][j];
            curr = curr.child[ch-'a'];
            if(curr.isTerminal != null) {
                ans.add(curr.isTerminal);
                curr.isTerminal = null;//to avoid repetitive addition
            }
            board[i][j] = '*';
            search(board, i+1, j, curr);
            search(board, i-1, j, curr);
            search(board, i, j+1, curr);
            search(board, i, j-1, curr);
            board[i][j] = ch;
        }
    }
    List<String> ans = new ArrayList<>();
    public List<String> findWords(char[][] board, String[] words) {
        Trie trie = new Trie();
        for(String word: words) {
            trie.insert(word);
        }
        for(int i = 0; i < board.length; i++) {
            for(int j = 0; j < board[0].length; j++) {
                char ch = board[i][j];
                if(trie.root.child[ch-'a'] != null) {
                    trie.search(board, i, j, trie.root);
                }
            }
        }
        return ans;
    }
}