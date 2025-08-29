class Solution {
    public int[][] kClosest(int[][] points, int k) {
        PriorityQueue<int[]> pq = new PriorityQueue<>(new Comparator<>(){
            @Override
            public int compare(int[] a1, int[] a2) {
                int x1 = (a1[0]*a1[0])+(a1[1]*a1[1]);
                int x2 =(a2[0]*a2[0])+(a2[1]*a2[1]);
                return x2 - x1;
            }
        });
        for(int[] point:points) {
            if(pq.size() < k) {
                pq.add(point);
            }
            else {
                int x1 = (pq.peek()[0]*pq.peek()[0])+(pq.peek()[1]*pq.peek()[1]);
                int x2 = (point[0]*point[0])+(point[1]*point[1]);
                if(x1 > x2) {
                    pq.poll();
                    pq.add(point);
                }
            }
        }
        int[][] ans = new int[k][2];
        int idx = 0;
        while(!pq.isEmpty()) {
            ans[idx++] = pq.poll();
        }
        return ans;
    }
}