class Solution {
    public int[] resultsArray(int[][] queries, int k) {
        int[] results = new int[queries.length];
        PriorityQueue<Integer> pq = new PriorityQueue<>(Collections.reverseOrder());
        for(int i = 0; i < queries.length; i++) {
            int x = Math.abs(queries[i][0])+Math.abs(queries[i][1]);
            if(pq.size() < k) {
                pq.add(x);
            }
            else if(pq.peek() > x) {
                pq.poll();
                pq.add(x);
            }
            if(pq.size() < k) {
                results[i] = -1;
            }
            else {
                results[i] = pq.peek();
            }
        }
        return results;
    }
}