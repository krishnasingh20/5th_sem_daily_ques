class Solution {
    public int maximumProduct(int[] nums, int k) {
        PriorityQueue<Integer> pq = new PriorityQueue<>();
        for(int num: nums) {
            pq.add(num);
        }
        while(k-- > 0) {
            int x = pq.poll();
            pq.add(x+1);
        }
        long pro = 1;
        while(!pq.isEmpty()) {
            pro = (pro * pq.poll()) % 1000000007;
        }
        return (int)pro;
    }
}