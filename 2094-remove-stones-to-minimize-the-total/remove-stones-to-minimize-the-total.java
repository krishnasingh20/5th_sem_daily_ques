class Solution {
    public int minStoneSum(int[] piles, int k) {
        PriorityQueue<Integer> pq = new PriorityQueue<>(Collections.reverseOrder());
        int sum = 0;
        for(int pile: piles) {
            sum += pile;
            pq.add(pile);
        }
        while(k-- > 0) {
            int x = pq.poll();
            int y = (int)Math.floor((x*1.0)/2);
            sum -= y;
            pq.add(x - y);
        }
        return sum;
    }
}