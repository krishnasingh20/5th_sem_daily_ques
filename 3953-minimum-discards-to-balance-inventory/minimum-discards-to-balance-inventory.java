class Solution {
    public int minArrivalsToDiscard(int[] arrivals, int w, int m) {
        HashMap<Integer, Integer> map = new HashMap<>();
        int ans = 0;
        for(int i = 0; i < w; i++) {
            map.put(arrivals[i], map.getOrDefault(arrivals[i], 0) + 1);
            if(map.get(arrivals[i]) > m) {
                ans++;
                map.put(arrivals[i], map.get(arrivals[i]) - 1);
                map.put(-1, map.getOrDefault(-1, 0)+1);
                arrivals[i] = -1;
            }
        }
        for(int i = w; i < arrivals.length; i++) {
            map.put(arrivals[i], map.getOrDefault(arrivals[i], 0)+1);
            map.put(arrivals[i-w], map.get(arrivals[i-w]) - 1);
            if(map.get(arrivals[i]) > m) {
                ans++;
                map.put(arrivals[i], map.get(arrivals[i]) - 1);
                map.put(-1, map.getOrDefault(-1, 0)+1);
                arrivals[i] = -1;
            }
        }
        return ans;
    }
}