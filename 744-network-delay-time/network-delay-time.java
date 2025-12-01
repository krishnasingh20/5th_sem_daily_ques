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
        PriorityQueue<DijkstraPair> pq = new PriorityQueue<>(new Comparator<DijkstraPair>(){
            @Override
            public int compare(DijkstraPair a, DijkstraPair b) {
                return a.time - b.time;
            }
        });
        pq.add(new DijkstraPair(k, 0));
        HashSet<Integer> visited = new HashSet<>();
        while(!pq.isEmpty()) {
            DijkstraPair rp = pq.poll();//remove
            if(visited.contains(rp.vtx)) {//ignore if already visited
                continue;
            }
            visited.add(rp.vtx);//marked visited
            totalTime = Math.max(totalTime, rp.time);//self work
            count++;//to know how many node we have visited
            for(int nbrs: map.get(rp.vtx).keySet()) {//add all unvisited neighbour
                if(!visited.contains(nbrs)) {
                    int time = rp.time + map.get(rp.vtx).get(nbrs);
                    pq.add(new DijkstraPair(nbrs, time));
                }
            }
        }
        return count==n?totalTime:-1;
    }
    class DijkstraPair {
        int vtx;
        int time;
        public DijkstraPair(int vtx, int time) {
            this.vtx = vtx;
            this.time = time;
        }
    }
}