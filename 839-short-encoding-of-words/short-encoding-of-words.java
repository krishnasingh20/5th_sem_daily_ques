class Solution {
    class Trie {
        class Node {
            boolean isTerminal;
            Node[] child = new Node[26];
        }
        private Node root;

        public Trie() {
            root = new Node();
        }

        public void insert(String s) {
            Node curr = root;
            boolean change = false;
            for(int i = s.length()-1; i >= 0; i--) {
                int x = s.charAt(i)-'a';
                if(curr.child[x] != null) {
                    curr = curr.child[x];
                    if(curr.isTerminal) {
                        curr.isTerminal = false;
                        change = true;
                    }
                }
                else {
                    curr.child[x] = new Node();
                    curr = curr.child[x];
                    change = true;
                }
            }
            if(change) {
                curr.isTerminal = true;
            }
        }

        int ans;
        public int find() {
            ans = 0;
            dfs(root, 0);
            return ans;
        }

        private void dfs(Node curr, int c) {
            if(curr.isTerminal) {
                ans += c+1;
                return;
            }
            for(int i = 0; i < 26; i++) {
                if(curr.child[i] != null) {
                    dfs(curr.child[i], c+1);
                }
            }
        }
    }
    public int minimumLengthEncoding(String[] words) {
        Trie trie = new Trie();
        int n = words.length;

        for(int i = 0; i < n; i++) {
            trie.insert(words[i]);
        }

        return trie.find();
    }
}