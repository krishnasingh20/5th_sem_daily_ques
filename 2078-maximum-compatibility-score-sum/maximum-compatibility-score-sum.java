class Solution {
    int ans = 0;
    public int maxCompatibilitySum(int[][] students, int[][] mentors) {
        int m = students.length;
        int n = students[0].length;
        max(students, mentors, new boolean[m], 0, n, m, 0);
        return ans;
    }
    private void max(int[][] students, int[][] mentors, boolean[] visit, int i, int n, int m, int curr) {
        if(i == m) {
            ans = Math.max(ans, curr);
            return;
        }
        for(int j = 0; j < m; j++) {
            if(!visit[j]) {
                visit[j] = true;
                int c = 0;
                for(int k = 0; k < n; k++) {
                    if(students[j][k] == mentors[i][k]) {
                        c++;
                    }
                }
                max(students, mentors, visit, i+1, n, m, curr+c);
                visit[j] = false;
            }
        }
    }
}