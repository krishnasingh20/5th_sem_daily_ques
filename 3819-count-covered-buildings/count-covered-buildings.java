class Solution {
    public int countCoveredBuildings(int n, int[][] buildings) {
        Arrays.sort(buildings, (a, b)->a[0] == b[0]?a[1]-b[1]:a[0]-b[0]);
        HashMap<Integer, List<Integer>> map1 = new HashMap<>();
        HashMap<Integer, List<Integer>> map2 = new HashMap<>();
        for(int i = 0; i < buildings.length; i++) {
            int x = buildings[i][0];
            int y = buildings[i][1];
            if(!map1.containsKey(y)) {
                map1.put(y, new ArrayList<>());
            }
            if(!map2.containsKey(x)) {
                map2.put(x, new ArrayList<>());
            }
            map1.get(y).add(x);
            map2.get(x).add(y);
        }
        int ans = 0;
        for(int i = 0; i < buildings.length; i++) {
            int x = buildings[i][0];
            int y = buildings[i][1];
            List<Integer> ll1 = map1.get(y);
            List<Integer> ll2 = map2.get(x);
            if(ll1.get(0) == x || ll1.get(ll1.size() - 1) == x || ll1.size() < 3 || ll2.get(0) == y || ll2.get(ll2.size()-1) == y || ll2.size() < 3) {
                continue;
            }
            ans++;
        }
        return ans;
    }
}