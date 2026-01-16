class Solution {
    public int[] findOriginalArray(int[] changed) {
        int n = changed.length;
        if((n & 1) == 1) {
            return new int[]{};
        }
        HashMap<Integer, Integer> map = new HashMap<>();
        for(int i = 0; i < n; i++) {
            map.put(changed[i], map.getOrDefault(changed[i], 0)+1);
        }
        Arrays.sort(changed);
        int[] ans = new int[n/2];
        int idx = 0;
        for(int i = 0; i < n; i++) {
            if(map.get(changed[i]) > 0) {
                if(map.getOrDefault(changed[i]*2, 0) == 0) {
                    return new int[]{};
                }
                map.put(changed[i]*2, map.get(changed[i]*2)-1);
                map.put(changed[i], map.get(changed[i])-1);
                ans[idx++] = changed[i];
            }
        }
        return ans;
    }
}