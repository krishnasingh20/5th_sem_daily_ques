class Solution {

    class TrieNode {
        TrieNode[] child;
        int len;
        int idx;

        TrieNode() {
            child = new TrieNode[26];
        }
    }

    class Trie {
        private TrieNode root;

        Trie() {
            root = new TrieNode();
        }

        void insert(String s, int idx) {
            int n = s.length();
            TrieNode curr = root;

            for(int i = n-1; i >= 0; i--) {
                int x = s.charAt(i)-'a';
                if(curr.child[x] == null) {
                    curr.child[x] = new TrieNode();
                    curr = curr.child[x];
                    curr.len = n;
                    curr.idx = idx;
                }
                else {
                    curr = curr.child[x];
                    if(curr.len > n) {
                        curr.len = n;
                        curr.idx = idx;
                    }
                }
            }
        }

        int find(String s) {
            int ans = -1;
            TrieNode curr = root;
            int n = s.length();

            for(int i = n-1; i >= 0; i--) {
                int x = s.charAt(i)-'a';
                if(curr.child[x] == null) {
                    return ans;
                }
                curr = curr.child[x];
                ans = curr.idx;
            }

            return ans;
        }
    }

    public int[] stringIndices(String[] word, String[] query) {
        int m = word.length;
        int n = query.length;
        int[] ans = new int[n];
        int min = Integer.MAX_VALUE;
        int idx = -1;

        Trie trie = new Trie();

        for(int i = 0; i < m; i++) {
            trie.insert(word[i], i);

            if(word[i].length() < min) {
                min = word[i].length();
                idx = i;
            }
        }

        for(int i = 0; i < n; i++) {
            ans[i] = trie.find(query[i]);
            if(ans[i] == -1) {
                ans[i] = idx;
            }
        }

        return ans;
    }
}