class Solution {
    public int[] maxSlidingWindow(int[] nums, int k) {
        PriorityQueue<int[]> pq = new PriorityQueue<>((a, b)->b[0]-a[0]);
        for(int i = 0; i < k; i++) {
            pq.add(new int[]{nums[i], i});
        }
        int[] ans = new int[nums.length - k + 1];
        int idx = 0;
        ans[idx++] = pq.peek()[0];
        for(int i = k; i < nums.length; i++) {
            pq.add(new int[]{nums[i], i});
            if(pq.peek()[1] <= i-k) {
                while(pq.size() > k && pq.peek()[1] <= i - k) {
                    pq.poll();
                }
            }
            ans[idx++] = pq.peek()[0];
        }
        return ans;
    }
}