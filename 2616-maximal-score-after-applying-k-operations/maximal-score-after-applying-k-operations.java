class Solution {
    public long maxKelements(int[] nums, int k) {
        PriorityQueue<Integer> pq = new PriorityQueue<>(Collections.reverseOrder());
        long score = 0;
        for(int num: nums) {
            pq.add(num);
        }
        while(k-- > 0) {
            int val = pq.poll();
            score += val;
            int a = (int)Math.ceil((val*1.0)/3);
            pq.add(a);
        }
        return score;
    }
}