class Solution {
    public int minOperations(int[] nums, int k) {
        PriorityQueue<Long> pq = new PriorityQueue<>();
        for(int num: nums) {
            pq.add((long)num);
        }
        int operation = 0;
        while(pq.size() >= 2 && pq.peek() < k) {
            long a = pq.poll();
            long b = pq.poll();
            long val = Math.min(a, b) * 2 + Math.max(a, b);
            pq.add(val);
            operation++;
        }
        return operation;
    }
}