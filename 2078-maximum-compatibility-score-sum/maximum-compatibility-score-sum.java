class Solution {
    int ans = 0;
    HashMap<Integer, HashMap<Integer, Integer>> map;
    boolean[] visit;
    public int maxCompatibilitySum(int[][] students, int[][] mentors) {
        int m = students.length;
        int n = students[0].length;
        map = new HashMap<>();
        for(int i = 0; i < m; i++) {
            map.put(i, new HashMap<>());
            for(int j = 0; j < m; j++) {
                int c = 0;
                for(int k = 0; k < n; k++) {
                    if(students[i][k] == mentors[j][k]) {
                        c++;
                    }
                }
                map.get(i).put(j, c);
            }
        }
        visit = new boolean[m];
        max(0, m, 0);
        return ans;
    }
    private void max(int i, int m, int curr) {
        if(i == m) {
            ans = Math.max(ans, curr);
            return;
        }
        for(int j = 0; j < m; j++) {
            if(!visit[j]) {
                visit[j] = true;
                int c = map.get(i).get(j);
                max(i+1, m, curr+c);
                visit[j] = false;
            }
        }
    }
}