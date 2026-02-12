class Solution {
    public int[] maximizeXor(int[] nums, int[][] queries) {
        Trie trie = new Trie();
        Arrays.sort(nums);
        int n = nums.length;
        int m = queries.length;
        int[][] arr = new int[m][3];
        for(int i = 0; i < m; i++) {
            arr[i] = new int[]{queries[i][0], queries[i][1], i};
        }
        Arrays.sort(arr, (a, b)->Integer.compare(a[1], b[1]));
        int[] ans = new int[m];
        int j = 0;
        for(int i = 0; i < m; i++) {
            while(j < n && nums[j] <= arr[i][1]) {
                trie.add(nums[j]);
                j++;
            }
            if(j == 0) {
                ans[arr[i][2]] = -1;
            }
            else {
                ans[arr[i][2]] = trie.maxXOR(arr[i][0]);
            }
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
        public void add(int num) {
            Node curr = root;
            for(int i = 30; i >= 0; i--) {
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
            for(int i = 30; i >= 0; i--) {
                int mask = (1<<i);
                if((mask & num) != 0) {
                    if(curr.zero != null) {
                        ans |= mask;
                        curr = curr.zero;
                    }
                    else {
                        curr = curr.one;
                    }
                }
                else {
                    if(curr.one != null) {
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