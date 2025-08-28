class Solution {
    public int[] topKFrequent(int[] nums, int k) {
        HashMap<Integer, Integer> map = new HashMap<>();
        for(int i: nums) {
            map.put(i, map.getOrDefault(i, 0) + 1);
        }
        PriorityQueue<int[]> pq = new PriorityQueue<>(new Comparator<>(){
            @Override
            public int compare(int[] a1, int[] a2) {
                return a1[1]-a2[1];
            }
        });
        for(int key:map.keySet()) {
            if(pq.size() < k) {
                pq.add(new int[]{key, map.get(key)});
            }
            else {
                if(pq.peek()[1] < map.get(key)) {
                    pq.poll();
                    pq.add(new int[]{key, map.get(key)});
                }
            }
        }
        int[] ans = new int[k];
        int idx = 0;
        while(!pq.isEmpty()) {
            ans[idx++] = pq.poll()[0];
        }
        return ans;
    }
}