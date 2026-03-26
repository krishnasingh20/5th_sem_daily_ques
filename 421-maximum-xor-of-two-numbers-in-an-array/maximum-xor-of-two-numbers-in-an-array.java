class Solution {
    public int findMaximumXOR(int[] nums) {
        int ans = 0;
        int n = nums.length;

        Trie trie = new Trie();

        for(int i = 0; i < n; i++) {
            trie.insert(nums[i]);
            ans = Math.max(ans, trie.maxXOR(nums[i]));
        }

        return ans;
    }
    class Trie {

        class Node {
            Node one;
            Node zero;
        }

        private Node root;

        public Trie() {
            root = new Node();
        }

        public void insert(int num) {
            Node curr = root;

            for(int i = 31; i >= 0; i--) {
                int mask = (1 << i);

                if((num & mask) != 0) {
                    if(curr.one != null) {
                        curr = curr.one;
                    }
                    else {
                        curr.one = new Node();
                        curr = curr.one;
                    }
                }
                else  {
                    if(curr.zero != null) {
                        curr = curr.zero;
                    }
                    else {
                        curr.zero = new Node();
                        curr = curr.zero;
                    }
                }
            }
        }

        public int maxXOR(int num) {
            int ans = 0;
            Node curr = root;

            for(int i = 31; i >= 0; i--) {
                int mask = (1 << i);

                if((num & mask) != 0) {
                    if(curr.zero != null) {
                        ans += mask;
                        curr = curr.zero;
                    }
                    else {
                        curr = curr.one;
                    }
                }
                else {
                    if(curr.one != null) {
                        ans += mask;
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