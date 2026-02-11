class Solution {
    public int findMaximumXOR(int[] nums) {
        Trie trie = new Trie();
        for(int num: nums) {
            trie.add(num);
        }
        int ans = 0;
        for(int num: nums) {
            ans = Math.max(ans, trie.maxXOR(num));
        }
        return ans;
    }
    class Trie {
        class Node {
            Node one;
            Node zero;
        }
        public Trie() {
            root = new Node();
        }
        private Node root;
        public void add(int num) {
            Node curr = root;
            for(int i = 31; i >= 0; i--) {
                int mask = (1<<i);
                if((mask & num) != 0) {
                    if(curr.one == null) {
                        Node one = new Node();
                        curr.one = one;
                    }
                    curr = curr.one;
                }
                else {
                    if(curr.zero == null) {
                        Node zero = new Node();
                        curr.zero = zero;
                    }
                    curr = curr.zero;
                }
            }
        }
        public int maxXOR(int num) {
            int ans = 0;
            Node curr = root;
            for(int i = 31; i >= 0; i--) {
                int mask = (1<<i);
                if((mask & num) != 0) {
                    if(curr.zero != null) {
                        ans |= (1<<i);
                        curr = curr.zero;
                    }
                    else {
                        curr = curr.one;
                    }
                }
                else {
                    if(curr.one != null) {
                        ans |= (1<<i);
                        curr = curr.one;
                    }
                    else {
                        curr = curr.zero;
                    }
                }
            }
            return ans;
        }
    }
}