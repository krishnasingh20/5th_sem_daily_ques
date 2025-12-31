class Solution {
    public double maxProbability(int n, int[][] edges, double[] succProb, int src, int end) {
        List<double[]>[] graph = new ArrayList[n];
        for(int i = 0; i < n; i++) {
            graph[i] = new ArrayList<>();
        }
        for(int i = 0; i < edges.length; i++) {
            double[] a = new double[2];
            a[0] = edges[i][1];
            a[1] = succProb[i];
            graph[edges[i][0]].add(a);
            double[] b = new double[2];
            b[0] = edges[i][0];
            b[1] = succProb[i];
            graph[edges[i][1]].add(b);
        }
        PriorityQueue<Pair> pq = new PriorityQueue<>((a, b)->Double.compare(b.prob, a.prob));
        pq.add(new Pair(src, 1.0));
        boolean[] visited = new boolean[n];
        while(!pq.isEmpty()) {
            Pair rv = pq.poll();
            if(visited[rv.vtx]) {
                continue;
            }
            visited[rv.vtx] = true;
            if(rv.vtx == end) {
                return rv.prob;
            }
            for(double[] nbrs: graph[rv.vtx]) {
                int nbr = (int)nbrs[0];
                if(!visited[nbr]) {
                    pq.add(new Pair(nbr, rv.prob*nbrs[1]));
                }
            }
        }
        return 0.0;
    }
    class Pair{
        int vtx;
        double prob;
        public Pair(int vtx, double prob) {
            this.vtx = vtx;
            this.prob = prob;
        }
    }
}