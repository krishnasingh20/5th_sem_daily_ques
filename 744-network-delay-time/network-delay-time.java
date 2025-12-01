class Solution {
    public int networkDelayTime(int[][] times, int n, int k) {
        HashMap<Integer, HashMap<Integer, Integer>> map = new HashMap<>();
        for(int i = 1; i <= n; i++) {
            map.put(i, new HashMap<>());
        }
        for(int[] time: times) {
            map.get(time[0]).put(time[1], time[2]);
        }
        int totalTime = 0;
        int count = 0;
        PriorityQueue<int[]> pq = new PriorityQueue<>((a, b)->a[1]-b[1]);
        pq.add(new int[]{k, 0});
        boolean[] visited = new boolean[n+1];
        while(!pq.isEmpty()) {
            int[] rp = pq.poll();//remove
            if(visited[rp[0]]) {//ignore if already visited
                continue;
            }
            visited[rp[0]] = true;//marked visited
            totalTime = Math.max(totalTime, rp[1]);//self work
            count++;//to know how many node we have visited
            for(int nbrs: map.get(rp[0]).keySet()) {//add all unvisited neighbour
                if(!visited[nbrs]) {
                    int time = rp[1] + map.get(rp[0]).get(nbrs);
                    pq.add(new int[]{nbrs, time});
                }
            }
        }
        return count==n?totalTime:-1;
    }
}