class Solution {
    public int minimumJumps(int[] forbidden, int a, int b, int x) {
        boolean[][] visited = new boolean[10001][2];
        for(int i = 0; i < forbidden.length; i++) {
            visited[forbidden[i]][0] = true;
            visited[forbidden[i]][1] = true;
        }
        int step = 0;
        Queue<int[]> q = new LinkedList<>();
        q.add(new int[]{0,0});
        visited[0][0] = true;
        while(!q.isEmpty()) {
            int size = q.size();
            while(size-- > 0) {
                int[] rv = q.poll();
                if(rv[0] == x) {
                    return step;
                }
                int state = rv[1];
                if(state == 0) {
                    int nX = rv[0]+a;
                    if(nX < 10001 && !visited[nX][0]) {
                        visited[nX][0] = true;
                        q.add(new int[]{nX, 0});
                    }
                    int nY = rv[0]-b;
                    if(nY >= 0 && !visited[nY][1]) {
                        visited[nY][1] = true;
                        q.add(new int[]{nY, 1});
                    }
                }
                else {
                    int nX = rv[0]+a;
                    if(nX < 10001 && !visited[nX][0]) {
                        visited[nX][0] = true;
                        q.add(new int[]{nX, 0});
                    }
                }
            }
            step++;
        }
        return -1;
    }
}