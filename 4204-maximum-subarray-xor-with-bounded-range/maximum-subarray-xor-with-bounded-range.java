class Solution {
    public int maxXor(int[] nums, int k) {
        Trie trie = new Trie();
        trie.add(0);
        int n = nums.length;
        int[] prefix = new int[n+1];
        for(int i = 0; i < n; i++) {
            prefix[i+1] = prefix[i] ^ nums[i];
        }
        TreeMap<Integer, Integer> map = new TreeMap<>();
        int si = 0;
        int ei = 0;
        int ans = 0;
        while(ei < n) {
            map.put(nums[ei], map.getOrDefault(nums[ei], 0)+1);
            int max = map.lastKey();
            int min = map.firstKey();
            while(max - min > k) {
                trie.remove(prefix[si]);
                int val = map.get(nums[si]);
                if(val == 1) {
                    map.remove(nums[si]);
                }
                else {
                    map.put(nums[si], val-1);
                }
                si++;
                max = map.lastKey();
                min = map.firstKey();
            }
            int currXor = prefix[ei+1];
            ans = Math.max(ans, trie.maxXOR(currXor));
            trie.add(currXor);
            ei++;
        }
        return ans;
    }
    class Trie {
        class Node {
            int count;
            Node one;
            Node zero;
        }
        private Node root;
        public Trie() {
            this.root = new Node();
        }
        public void add(int num) {
            Node curr = root;
            for(int i = 15; i >= 0; i--) {
                int mask = (1<<i);
                if((mask & num) != 0) {
                    if(curr.one != null) {
                        curr = curr.one;
                        curr.count++;
                    }
                    else {
                        Node one = new Node();
                        curr.one = one;
                        curr = one;
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
                        curr = zero;
                        curr.count++;
                    }
                }
            }
        }
        public void remove(int num) {
            Node curr = root;
            for(int i = 15; i >= 0; i--) {
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
            for(int i = 15; i >= 0; i--) {
                int mask = (1<<i);
                if((mask & num) != 0) {
                    if(curr.zero != null && curr.zero.count > 0) {
                        curr = curr.zero;
                        ans |= mask;
                    }
                    else {
                        curr = curr.one;
                    }
                }
                else {
                    if(curr.one != null && curr.one.count > 0) {
                        curr = curr.one;
                        ans |= mask;
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