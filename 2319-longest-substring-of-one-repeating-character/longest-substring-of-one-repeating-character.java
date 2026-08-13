class Solution {
    class SegmentTree {
        class Node {
            int leftCount;
            int rightCount;
            int leftChar;
            int rightChar;
            int max;

            Node(){

            }

            Node(int leftCount, int leftChar, int rightCount, int rightChar, int max) {
                this.leftCount = leftCount;
                this.leftChar = leftChar;
                this.rightCount = rightCount;
                this.rightChar = rightChar;
                this.max = max;
            }
        }

        Node[] tree;
        int n;

        SegmentTree(int n) {
            this.n = n;
            tree = new Node[4*n];
        }

        void calculate(int node, int start, int end, int mid) {
            tree[node] = new Node();
            int max = tree[2*node].rightChar == tree[2*node + 1].leftChar ? tree[2*node].rightCount + tree[2*node + 1].leftCount : 0;

            max = Math.max(Math.max(tree[2*node].max, tree[2*node + 1].max), max);
            max = Math.max(max, Math.max(tree[2*node].leftCount, Math.max(tree[2*node].rightCount, Math.max(tree[2*node+1].leftCount, tree[2*node+1].rightCount))));

            tree[node].max = max;

            int leftCount = tree[2*node].leftCount;
            leftCount = leftCount == (mid-start+1) && tree[2*node].leftChar == tree[2*node+1].leftChar ? leftCount + tree[2*node+1].leftCount : leftCount;

            tree[node].leftCount = leftCount;
            tree[node].leftChar = tree[2*node].leftChar;

            int rightCount = tree[2*node+1].rightCount;
            rightCount = rightCount == (end - mid) && tree[2*node+1].rightChar == tree[2*node].rightChar ? rightCount + tree[2*node].rightCount : rightCount;

            tree[node].rightCount = rightCount;
            tree[node].rightChar = tree[2*node+1].rightChar;
        }

        void build(int node, int start, int end, String s) {
            if(start == end) {
                tree[node] = new Node(1, s.charAt(start)-'a', 1, s.charAt(start)-'a', 1);
                return;
            }

            int mid = (start + end)/2;

            build(2 * node, start, mid, s);
            build(2 * node + 1, mid + 1, end, s);

            calculate(node, start, end, mid);
        }

        void update(int node, int start, int end, int ch, int idx) {
            if(start == end) {
                tree[node] = new Node(1, ch, 1, ch, 1);
                return;
            }

            int mid = (start + end)/2;

            if(idx <= mid) {
                update(2*node, start, mid, ch, idx);
            }
            else {
                update(2*node+1, mid + 1, end, ch, idx);
            }

            calculate(node, start, end, mid);            
        }
    }
    public int[] longestRepeating(String s, String queryCharacters, int[] queryIndices) {
        int n = s.length();
        int k = queryIndices.length;

        SegmentTree seg = new SegmentTree(n);
        seg.build(1, 0, n-1, s);

        int[] ans = new int[k];

        for(int i = 0; i < k; i++) {
            seg.update(1, 0, n-1, queryCharacters.charAt(i)-'a', queryIndices[i]);
            ans[i] = seg.tree[1].max;
        }

        return ans;
    }
}