class Solution {
    int n;
    boolean[] visited;
    int ans = 0;
    public int longestCycle(int[] edges) {
        n = edges.length;
        visited = new boolean[n];
        boolean hasCycle = topoSort(edges);
        if(hasCycle) {
            return -1;
        }
        topoSortdfs(edges);
        return ans;
    }
    public void topoSortdfs(int[] edges) {
        for(int i = 0; i < n; i++) {
            if(!visited[i]) {
                dfs(i, 0, edges);
            }
        }
    }
    public void dfs(int src, int len, int[] edges) {
        visited[src] = true;
        if(edges[src] != -1) {
            if(visited[edges[src]]) {
                ans = Math.max(ans, len+1);
                visited[edges[src]] = true;
            }
            else {
                dfs(edges[src], len+1, edges);
            }
        }
    }
    public boolean topoSort(int[] edges) {
        int[] inDegree = new int[n];
        for(int i = 0; i < n; i++) {
            if(edges[i] != -1) {
                inDegree[edges[i]]++;
            }
        }
        Queue<Integer> q = new LinkedList<>();
        for(int i = 0; i < n; i++) {
            if(inDegree[i] == 0) {
                q.add(i);
            }
        }
        int count = 0;
        while(!q.isEmpty()) {
            int rv = q.poll();
            visited[rv] = true;
            count++;
            if(edges[rv] != -1) {
                inDegree[edges[rv]]--;
                if(inDegree[edges[rv]] == 0) {
                    q.add(edges[rv]);
                }
            }
        }
        return count == n;
    }
}