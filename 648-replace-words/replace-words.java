class Solution {
    class Trie {
        class Node {
            char ch;
            boolean isTerminal;
            HashMap<Character, Node> child;
            Node(char ch) {
                this.ch = ch;
                this.child = new HashMap<>();
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
                if(curr.child.containsKey(ch)) {
                    curr = curr.child.get(ch);
                }
                else {
                    Node nn = new Node(ch);
                    curr.child.put(ch, nn);
                    curr = nn;
                }
            }
            curr.isTerminal = true;
        }
        public String search(String word) {
            Node curr = root;
            for(int i = 0; i < word.length(); i++) {
                char ch = word.charAt(i);
                if(curr.child.containsKey(ch)) {
                    curr = curr.child.get(ch);
                    if(curr.isTerminal) {
                        return word.substring(0, i+1);
                    }
                }
                else{
                    return word;
                }
            }
            return word;
        }
    }
    public String replaceWords(List<String> dictionary, String sentence) {
        Trie trie = new Trie();
        for(String dict: dictionary) {
            trie.insert(dict);
        }
        String[] arr = sentence.split(" ");
        for(int i = 0; i < arr.length; i++) {
            arr[i] = trie.search(arr[i]);
        }
        return String.join(" ", arr);
    }
}