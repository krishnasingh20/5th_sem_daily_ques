class Solution {
    public int[] loudAndRich(int[][] richer, int[] quiet) {
        int n = quiet.length;
        int[] inDegree = new int[n];
        List<Integer>[] adj = new ArrayList[n];

        for(int i = 0; i < n; i++) {
            adj[i] = new ArrayList<>();
        }

        for(int[] rich: richer) {
            adj[rich[0]].add(rich[1]);
            inDegree[rich[1]]++;
        }

        Queue<Integer> q = new LinkedList<>();
        int[] ans = new int[n];

        for(int i = 0; i < n; i++) {
            if(inDegree[i] == 0) {
                q.add(i);
            }
            ans[i] = i;
        }

        while(!q.isEmpty()) {
            int rv = q.poll();
            for(int nbrs: adj[rv]) {
                if(quiet[ans[nbrs]] > quiet[ans[rv]]) {
                    ans[nbrs] = ans[rv];
                }
                if(--inDegree[nbrs] == 0) {
                    q.add(nbrs);
                }
            }
        }

        return ans;
    }
}