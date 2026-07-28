class Solution {
    public long[] mostFrequentIDs(int[] nums, int[] freq) {
        int n = nums.length;

        HashMap<Long, Long> map = new HashMap<>();
        PriorityQueue<long[]> pq = new PriorityQueue<>((a, b) -> Long.compare(b[1], a[1]));
        long[] ans = new long[n];

        for(int i = 0; i < n; i++) {
            
            long num = nums[i];
            long count = freq[i];

            if(!map.containsKey(num)) {
                map.put(num, count);
            }
            else {
                count += map.get(num);
                map.put(num, count);
            }

            while(!pq.isEmpty() && map.get(pq.peek()[0]) != pq.peek()[1]) {
                pq.poll();
            }
            
            pq.add(new long[]{num, count});

            ans[i] = pq.isEmpty() ? 0 : pq.peek()[1];
        }

        return ans;
    }
}