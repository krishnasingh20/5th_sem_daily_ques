class Solution {
    public int findJudge(int n, int[][] trust) {
        HashMap<Integer, List<Integer>> map = new HashMap<>();
        for(int i = 0; i < trust.length; i++) {
            int a = trust[i][0];
            int b = trust[i][1];
            if(!map.containsKey(a)) {
                map.put(a, new ArrayList<>());
            }
            map.get(a).add(b);
        }
        for(int i = 1; i <= n; i++) {
            if(!map.containsKey(i)) {
                boolean flag = false;
                for(int key: map.keySet()) {
                    if(!map.get(key).contains(i)) {
                        flag = true;
                        break;
                    }
                }
                if(!flag && map.size() == n-1) {
                    return i;
                }
            }
        }
        return -1;
    }
}