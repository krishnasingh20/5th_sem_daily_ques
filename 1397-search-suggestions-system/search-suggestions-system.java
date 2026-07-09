class Solution {
    class Node {
        List<String> ll;
        Node[] child;
        Node() {
            child = new Node[26];
            ll = new ArrayList<>();
        }
    }
    class Trie {
        Node root;
        Trie() {
            root = new Node();
        }

        void insert(String s) {
            int n = s.length();
            Node curr = root;
            for(int i = 0; i < n; i++) {
                int x = s.charAt(i)-'a';
                if(curr.child[x] == null) {
                    curr.child[x] = new Node();
                }
                curr = curr.child[x];
                if(curr.ll.size() < 3) {
                    curr.ll.add(s);
                }
            }
        }

        List<List<String>> find(String s) {
            List<List<String>> ans = new ArrayList<>();
            int n = s.length();
            Node curr = root;
            int idx = n;

            for(int i = 0; i < n; i++) {
                int x = s.charAt(i)-'a';
                if(curr.child[x] == null) {
                    idx = i;
                    break;
                }
                curr = curr.child[x];
                ans.add(curr.ll);
            }

            while(idx < n) {
                ans.add(new ArrayList<>());
                idx++;
            }

            return ans;
        }
    }
    public List<List<String>> suggestedProducts(String[] products, String searchWord) {
        int n = products.length;
        Arrays.sort(products, (a, b) -> {
            return a.compareTo(b);
        });

        Trie trie = new Trie();

        for(int i = 0; i < n; i++) {
            trie.insert(products[i]);
        }

        return trie.find(searchWord);
    }
}