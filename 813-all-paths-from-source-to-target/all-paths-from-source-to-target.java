class Solution {
    List<List<Integer>> ans;
    public List<List<Integer>> allPathsSourceTarget(int[][] graph) {
        ans = new ArrayList<>();
        List<Integer> ll = new ArrayList<>();
        ll.add(0);
        dfs(0, ll, new boolean[graph.length], graph);
        return ans;
    }
    public void dfs(int src, List<Integer> ll, boolean[] visited, int[][] graph) {
        if(src == graph.length-1) {
            ans.add(new ArrayList<>(ll));
            return;
        }
        visited[src] = true;
        for(int nbrs: graph[src]) {
            if(visited[nbrs]) {
                continue;
            }
            ll.add(nbrs);
            dfs(nbrs, ll, visited, graph);
            ll.remove(ll.size()-1);
        }
        visited[src] = false;
    }
}