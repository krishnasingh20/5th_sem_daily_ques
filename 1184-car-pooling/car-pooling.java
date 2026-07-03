class Solution {
    public boolean carPooling(int[][] trips, int cap) {
        
        PriorityQueue<int[]> pq = new PriorityQueue<>((a, b) -> Integer.compare(a[0], b[0]));
        Arrays.sort(trips, (a, b) -> {
            if(a[1] == b[1]) {
                return Integer.compare(a[2], b[2]);
            }
            return Integer.compare(a[1], b[1]);
        });

        int curr = 0;

        for(int i = 0; i < trips.length; i++) {
            while(!pq.isEmpty() && trips[i][1] >= pq.peek()[0]) {
                curr -= pq.poll()[1];
            }
            if(curr+trips[i][0] > cap) {
                return false;
            }
            pq.add(new int[]{trips[i][2], trips[i][0]});
            curr += trips[i][0];
        }

        return true;
    }
}