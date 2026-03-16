class Solution {
    public int[] sumOfDistancesInTree(int n, int[][] edges) {
        int[] dist = new int[n];
        int[] subtree = new int[n];
        List<List<Integer>> tree = new ArrayList<>();

        for(int i = 0; i < n; i++) {
            tree.add(new ArrayList<>());
        }

        for(int[] edge: edges) {
            tree.get(edge[0]).add(edge[1]);
            tree.get(edge[1]).add(edge[0]);
        }

        dfs1(0, tree, dist, subtree, new boolean[n]);

        int[] ans = new int[n];
        ans[0] = dist[0];

        dfs2(n, 0, tree, ans, dist, subtree, new boolean[n]);

        return ans;
    }

    private static void dfs1(int node, List<List<Integer>> tree, int[] dist, int[] subtree, boolean[] visited) {
        visited[node] = true;

        for(int child: tree.get(node)) {
            if(visited[child]) {
                continue;
            }
            dfs1(child, tree, dist, subtree, visited);
            dist[node] += dist[child] + subtree[child];
            subtree[node] += subtree[child];
        }

        subtree[node] += 1;
    }

    private static void dfs2(int n, int node, List<List<Integer>> tree, int[] ans, int[] dist, int[] subtree, boolean[] visited) {
        visited[node] = true;

        for(int child: tree.get(node)) {
            if(visited[child]) {
                continue;
            }
            ans[child] = ans[node] + n - 2*subtree[child];
            dfs2(n, child, tree, ans, dist, subtree, visited);
        }
    }
}