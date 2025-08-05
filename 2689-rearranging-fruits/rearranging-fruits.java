class Solution {
    public long minCost(int[] basket1, int[] basket2) {
        int minval = Integer.MAX_VALUE;
        HashMap<Integer, Integer> map = new HashMap<>();
        for(int i = 0; i < basket1.length; i++) {
            map.put(basket1[i], map.getOrDefault(basket1[i], 0) + 1);
            map.put(basket2[i], map.getOrDefault(basket2[i], 0) - 1);
            minval = Math.min(minval, basket1[i]);
            minval = Math.min(minval, basket2[i]);
        }
        List<Integer> ll = new ArrayList<>();
        for(int key: map.keySet()) {
            if(map.get(key) % 2 != 0) {
                return -1;
            }
            int diff = map.get(key);
            for(int i = 0; i < Math.abs(diff) / 2; i++) {
                ll.add(key);
            }
        }
        Collections.sort(ll);
        long ans = 0;
        int m = ll.size();
        for(int i = 0; i < m / 2; i++) {
            ans += Math.min(ll.get(i), 2 * minval);
        }
        return ans;
    }
}