class Solution {
    public int maximumStrongPairXor(int[] nums) {
        Arrays.sort(nums);
        Trie trie = new Trie();
        int ans = 0;
        int si = 0;
        int ei = 0;
        int n = nums.length;
        while(ei < n) {
            trie.add(nums[ei]);
            while(nums[ei] - nums[si] > nums[si]) {
                trie.remove(nums[si]);
                si++;
            }
            ans = Math.max(ans, trie.maxXOR(nums[ei]));
            ei++;
        }
        return ans;
    }
    class Trie {
        class Node {
            Node one;
            Node zero;
            int count;//it will denote from these node how many number goes
        }
        private Node root;

        public Trie() {
            this.root = new Node();
        }

        public void add(int num) {
            Node curr = root;
            for(int i = 20; i >= 0; i--) {
                int mask = (1<<i);
                if((mask & num) != 0) {
                    if(curr.one != null) {
                        curr = curr.one;
                        curr.count++;
                    }
                    else {
                        Node one = new Node();
                        curr.one = one;
                        curr = curr.one;
                        curr.count++;
                    }
                }
                else {
                    if(curr.zero != null) {
                        curr = curr.zero;
                        curr.count++;
                    }
                    else {
                        Node zero = new Node();
                        curr.zero = zero;
                        curr = curr.zero;
                        curr.count++;
                    }
                }
            }
        }

        public void remove(int num) {
            Node curr = root;
            for(int i = 20; i >= 0; i--) {
                int mask = (1<<i);
                if((mask & num) != 0) {
                    curr = curr.one;
                    curr.count--;
                }
                else {
                    curr = curr.zero;
                    curr.count--;
                }
            }
        }

        public int maxXOR(int num) {
            Node curr = root;
            int ans = 0;
            for(int i = 20; i >= 0; i--) {
                int mask = (1<<i);
                if((mask & num) != 0) {
                    if(curr.zero != null && curr.zero.count > 0) {
                        ans |= mask;
                        curr = curr.zero;
                    }
                    else {
                        curr = curr.one;
                    }
                }
                else {
                    if(curr.one != null && curr.one.count > 0) {
                        ans |= mask;
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