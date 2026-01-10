class Solution {
    public int[] avoidFlood(int[] rains) {
        HashMap<Integer, Integer> map = new HashMap<>();
        TreeSet<Integer> set = new TreeSet<>();
        int n = rains.length;
        for(int i = 0; i < n; i++) {
            if(rains[i] == 0) {
                set.add(i);
                continue;
            }
            Integer idx1 = map.get(rains[i]);
            if(idx1 != null) {
                if(set.isEmpty()) {
                    return new int[]{};
                }
                else {
                    Integer idx = set.higher(idx1);
                    if(idx == null) {
                        return new int[]{};
                    }
                    rains[idx] = rains[i];
                    set.remove(idx);
                    map.put(rains[i], i);
                }
            }
            else {
                map.put(rains[i], i);
            }
            rains[i] = -1;
        }
        for(int idx: set) {
            rains[idx] = 1;
        }
        return rains;
    }
}