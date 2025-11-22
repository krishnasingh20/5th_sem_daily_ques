class Solution {
    public int minRefuelStops(int target, int startFuel, int[][] stations) {
        int ans = 0;
        PriorityQueue<int[]> pq = new PriorityQueue<>((a, b)->b[1]-a[1]);
        long end = startFuel;
        if(end >= target) {
            return ans;
        }
        for(int i = 0; i < stations.length;) {
            if(end >= target) {
                return ans;
            }
            while(i < stations.length && end >= stations[i][0]) {
                pq.add(stations[i]);
                i++;
            }
            if(pq.isEmpty()) {
                break;
            }
            end += pq.poll()[1];
            ans++;
        }
        if(end >= target) {
            return ans;
        }
        while(!pq.isEmpty()) {
            end += pq.poll()[1];
            ans++;
            if(end >= target) {
                return ans;
            }
        }
        return -1;
    }
}