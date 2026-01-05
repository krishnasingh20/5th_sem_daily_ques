class Solution {
    public int secondMinimum(int n, int[][] edges, int time, int change) {
        List<Integer>[] graph = new ArrayList[n+1];
        for(int i = 1; i <= n; i++) {
            graph[i] = new ArrayList<>();
        }
        for(int[] edge: edges) {
            graph[edge[0]].add(edge[1]);
            graph[edge[1]].add(edge[0]);
        }
        Queue<int[]> q = new LinkedList<>();
        int[][] times = new int[n+1][2];
        for(int[] t: times) {
            Arrays.fill(t, Integer.MAX_VALUE);
        }
        q.add(new int[]{1, 0});
        while(!q.isEmpty()) {
            int[] rv = q.poll();
            for(int nbrs: graph[rv[0]]) {
                int newTime = rv[1];
                if((((newTime)/change) & 1) == 1) {
                    int rem = newTime % change;//these time is already spend between nodes for traffic signal change
                    newTime += change-rem;
                }
                newTime += time;
                if(newTime < times[nbrs][0]) {//when smaller then min1
                    times[nbrs][1] = times[nbrs][0];
                    times[nbrs][0] = newTime;
                    q.add(new int[]{nbrs, newTime});
                }
                else if(newTime > times[nbrs][0] && newTime < times[nbrs][1] ) {//smaller then min2 but greater then min1
                    times[nbrs][1] = newTime;
                    q.add(new int[]{nbrs, newTime});
                }
            }
        }
        return times[n][1];
    }
}