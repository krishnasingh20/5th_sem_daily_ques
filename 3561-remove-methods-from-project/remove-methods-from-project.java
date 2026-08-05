class Solution {
    public List<Integer> remainingMethods(int n, int k, int[][] invocations) {
        List<List<Integer>> adj = new ArrayList<>();

        for(int i = 0; i < n; i++) {
            adj.add(new ArrayList<>());
        }

        for(int[] invoke: invocations) {
            adj.get(invoke[0]).add(invoke[1]);
        }

        boolean[] visited = new boolean[n];
        Queue<Integer> q = new LinkedList<>();

        q.add(k);
        visited[k] = true;

        while(!q.isEmpty()) {
            int rv = q.poll();

            for(int nbrs: adj.get(rv)) {
                if(!visited[nbrs]) {
                    visited[nbrs] = true;
                    q.add(nbrs);
                }
            }
        }

        List<Integer> ans = new ArrayList<>();
        boolean flag = false;

        for(int[] invoke: invocations) {
            if(!visited[invoke[0]] && visited[invoke[1]]) {
                flag = true;
                break;
            }
        }

        for(int i = 0; i < n; i++) {
            if(!visited[i] || flag) {
                ans.add(i);
            }
        }

        return ans;
    }
}