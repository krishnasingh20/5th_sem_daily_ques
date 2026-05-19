class Solution {
    public int[] shortestAlternatingPaths(int n, int[][] redEdges, int[][] blueEdges) {
        List<List<int[]>> adj = new ArrayList<>();

        for(int i = 0; i < n; i++) {
            adj.add(new ArrayList<>());
        }

        for(int[] e: redEdges) {
            adj.get(e[0]).add(new int[]{e[1], 0});
        }

        for(int[] e: blueEdges) {
            adj.get(e[0]).add(new int[]{e[1], 1});
        }

        Queue<int[]> q = new LinkedList<>();
        int[] ans = new int[n];
        boolean[][] visited = new boolean[n][2];
        Arrays.fill(ans, -1);
        
        q.add(new int[]{0, 0});
        q.add(new int[]{0, 1});
        int len = 0;
        visited[0][0] = true;

        while(!q.isEmpty()) {
            int size = q.size();
            while(size-- > 0) {
                int[] rv = q.poll();
                if(ans[rv[0]] == -1) {
                    ans[rv[0]] = len;
                }
                for(int[] nbrs: adj.get(rv[0])) {
                    if(nbrs[1] == 0) {
                        if(rv[1] == 1) {
                            if(!visited[nbrs[0]][0]) {
                                visited[nbrs[0]][0] = true;
                                q.add(nbrs);
                            }
                        }
                    }
                    else {
                        if(rv[1] == 0) {
                            if(!visited[nbrs[0]][1]) {
                                visited[nbrs[0]][1] = true;
                                q.add(nbrs);
                            }
                        }
                    }
                }
            }
            len++;
        }

        return ans;
    }
}