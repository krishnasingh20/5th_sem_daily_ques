class Solution {
    public boolean canMeasureWater(int x, int y, int target) {
        boolean[][] visited = new boolean[x+1][y+1];
        Queue<int[]> q = new LinkedList<>();
        q.add(new int[]{0, 0});
        while(!q.isEmpty()) {
            int[] rv = q.poll();
            if(visited[rv[0]][rv[1]]) {
                continue;
            }
            visited[rv[0]][rv[1]] = true;
            if(rv[0]+rv[1] == target) {
                return true;
            }
            // case-1
            if(!visited[x][rv[1]]) {
                q.add(new int[]{x, rv[1]});
            }
            if(!visited[rv[0]][y]) {
                q.add(new int[]{rv[0], y});
            }
            // case-2
            if(!visited[0][rv[1]]) {
                q.add(new int[]{0, rv[1]});
            }
            if(!visited[rv[0]][0]) {
                q.add(new int[]{rv[0], 0});
            }
            // case-3
            int req1 = y - rv[1];
            int temp1 = Math.min(req1, rv[0]);
            if(!visited[rv[0]-temp1][rv[1]+temp1]) {
                q.add(new int[]{rv[0]-temp1, rv[1]+temp1});
            }
            int req2 = x - rv[0];
            int temp2 = Math.min(req2, rv[1]);
            if(!visited[rv[0]+temp2][rv[1]-temp2]) {
                q.add(new int[]{rv[0]+temp2, rv[1]-temp2});
            }
        }
        return false;
    }
}