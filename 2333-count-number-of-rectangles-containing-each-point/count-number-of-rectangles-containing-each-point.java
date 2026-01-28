class Solution {
    public int[] countRectangles(int[][] rectangles, int[][] points) {
        HashMap<Integer, List<Integer>> map = new HashMap<>();
        for(int[] rect: rectangles) {
            map.putIfAbsent(rect[1], new ArrayList<>());
            map.get(rect[1]).add(rect[0]);
        }
        for(int key: map.keySet()) {
            List<Integer> ll = map.get(key);
            Collections.sort(ll);
        }
        int[] ans = new int[points.length];
        for(int i = 0; i < points.length; i++) {
            int x = points[i][0];
            int y = points[i][1];
            for(int key: map.keySet()) {
                if(key >= y) {
                    List<Integer> ll = map.get(key);
                    int n = ll.size();
                    int low = 0;
                    int high = n-1;
                    int idx = -1;
                    while(low <= high) {
                        int mid = low + (high - low)/2;
                        if(ll.get(mid) >= x) {
                            idx = mid;
                            high = mid - 1;
                        }
                        else {
                            low = mid + 1;
                        }
                    }
                    if(idx != -1) {
                        ans[i] += (n-idx);
                    }
                }
            }
        }
        return ans;
    }
}