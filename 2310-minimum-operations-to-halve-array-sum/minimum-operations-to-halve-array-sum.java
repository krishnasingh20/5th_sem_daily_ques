class Solution {
    public int halveArray(int[] nums) {
        PriorityQueue<Double> pq = new PriorityQueue<>(Collections.reverseOrder());
        double sum = 0.0;
        for(int num: nums) {
            sum += num;
            pq.add((num*1.0));
        }
        int operation = 0;
        double half = sum / 2;
        while(!pq.isEmpty() && sum > half) {
            double a = pq.poll();
            a /= 2;
            sum -= a;
            pq.add(a);
            operation++;
        }
        return operation;
    }
}