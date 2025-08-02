class Solution {
    public long minCost(int[] basket1, int[] basket2) {
        HashMap<Integer, Integer> map = new HashMap<>();
        int minval = Integer.MAX_VALUE;
        for(int i = 0; i < basket1.length; i++) {
            map.put(basket1[i], map.getOrDefault(basket1[i], 0) + 1);
            minval = Math.min(minval, basket1[i]);
        }
        
        for(int i = 0; i < basket2.length; i++) {
            map.put(basket2[i], map.getOrDefault(basket2[i], 0) - 1);
            minval = Math.min(minval, basket2[i]);
        }

        List<Integer> ll = new ArrayList<>();
        for(int key: map.keySet()) {
            int diff = map.get(key);
            if(diff % 2 != 0) {
                return -1;
            }
            for(int i = 0; i < Math.abs(diff) / 2; i++) {
                ll.add(key);
            }
        }
        Collections.sort(ll);
        long mincost = 0;
        int m = ll.size();
        for(int i = 0; i < m / 2; i++) {
            int a = ll.get(i);
            mincost += Math.min(a, 2 * minval);
        }
        return mincost;
    }
}