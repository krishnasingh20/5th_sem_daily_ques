class Solution {
    public int countArrangement(int n) {
        boolean[] visit = new boolean[n+1];
        return count(n, visit, 1);
    }
    public int count(int n, boolean[] visit, int curr) {
        if(curr == n+1) {
            return 1;
        }
        int c = 0;
        for(int i = 1; i <= n; i++) {
            if((!visit[i]) && (curr % i == 0 || i % curr == 0)) {
                visit[i] = true;
                c += count(n, visit, curr+1);
                visit[i] = false;
            }
        }
        return c;
    }
}