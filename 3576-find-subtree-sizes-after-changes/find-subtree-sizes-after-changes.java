class Solution {
    String s;
    int[] p;
    int[] arr;
    List<List<Integer>> adj;
    int[] ans;
    public int[] findSubtreeSizes(int[] parent, String s) {
        int n = parent.length;
        this.s = s;
        p = parent;

        adj = new ArrayList<>();

        for(int i = 0; i < n; i++) {
            adj.add(new ArrayList<>());
        }

        for(int i = 1; i < n; i++) {
            adj.get(p[i]).add(i);
        }

        arr = new int[26];
        Arrays.fill(arr, -1);

        dfs1(0);

        for(int i = 0; i < n; i++) {
            adj.get(i).clear();
        }

        for(int i = 1; i < n; i++) {
            adj.get(p[i]).add(i);
        }

        ans = new int[n];

        dfs2(0);

        return ans;
    }

    public void dfs1(int src) {
        if(arr[s.charAt(src)-'a'] != -1) {
            p[src] = arr[s.charAt(src)-'a'];
        }

        int temp = arr[s.charAt(src)-'a'];

        arr[s.charAt(src)-'a'] = src;

        for(int nbrs: adj.get(src)) {
            dfs1(nbrs);
        }

        arr[s.charAt(src)-'a'] = temp;
    }

    public int dfs2(int src) {
        int c = 0;

        for(int nbrs: adj.get(src)) {
            c += dfs2(nbrs);
        }

        ans[src] = c+1;

        return ans[src];
    }
}