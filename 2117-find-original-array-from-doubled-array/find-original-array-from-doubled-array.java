class Solution {
    public int[] findOriginalArray(int[] changed) {
        int n = changed.length;
        if(n % 2 != 0) {
            return new int[]{};
        }
        HashMap<Integer, Integer> map = new HashMap<>();
        for(int i = 0; i < n; i++) {
            map.put(changed[i], map.getOrDefault(changed[i], 0) + 1);
        }
        // int i = 0;
        int idx = 0;
        int[] ans = new int[n/2];
        Arrays.sort(changed);
        for(int i = 0; i < n; i++) {
            int x = changed[i];
            if(map.get(x) > 0) {
                map.put(x, map.get(x) - 1);
                if(map.getOrDefault(2*x, 0) > 0) {
                    ans[idx++] = x;
                    map.put(2*x, map.get(2*x) - 1);
                }
            }
        }
        if(idx == n/2) {
            return ans;
        }
        return new int[]{};
    }
}