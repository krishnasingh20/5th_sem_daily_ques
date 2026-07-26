class Solution {

    class Pair {
        int x;
        int y;
        int action;
        long cost;
        Pair(int _x, int _y, int _action, long _cost) {
            x = _x;
            y = _y;
            action = _action;
            cost = _cost;
        }
    }

    static int[] dx = {-1, 0, 1, 0};
    static int[] dy = {0, -1, 0, 1};

    public long minCost(int m, int n, int[][] penalty) {

        long[][][] cost = new long[m][n][2];

        for(long[][] arr: cost) {
            for(long[] a: arr) {
                Arrays.fill(a, Long.MAX_VALUE);
            }
        }

        PriorityQueue<Pair> pq = new PriorityQueue<>((a, b) -> {
            return Long.compare(a.cost, b.cost);
        });

        cost[0][0][0] = 1;
        cost[0][0][1] = 1 + penalty[0][0];
        pq.add(new Pair(0, 0, 0, 1));
        pq.add(new Pair(0, 0, 1, cost[0][0][1]));

        while(!pq.isEmpty()) {
            Pair rv = pq.poll();

            if(rv.cost > cost[rv.x][rv.y][rv.action]) {
                continue;
            }

            int newAction = rv.action ^ 1;

            for(int i = 0; i < 4; i++) {
                int nX = rv.x + dx[i];
                int nY = rv.y + dy[i];

                if(nX < 0 || nY < 0 || nX >= m || nY >= n) {
                    continue;
                }

                long curr = cost[rv.x][rv.y][rv.action] + ((nX+1)*(nY+1));

                if(i < 2) {
                    if(newAction == 1) {
                        curr += penalty[rv.x][rv.y];
                    }

                    if(cost[nX][nY][newAction] > curr) {
                        cost[nX][nY][newAction] = curr;
                        pq.add(new Pair(nX, nY, newAction, curr));
                    }
                }
                else {
                    if(newAction == 0) {
                        curr += penalty[rv.x][rv.y];
                    }

                    if(curr < cost[nX][nY][newAction]) {
                        cost[nX][nY][newAction] = curr;
                        pq.add(new Pair(nX, nY, newAction, curr));
                    }
                }
            }

            long curr = cost[rv.x][rv.y][rv.action] + penalty[rv.x][rv.y];

            if(curr < cost[rv.x][rv.y][newAction]) {
                cost[rv.x][rv.y][newAction] = curr;
                pq.add(new Pair(rv.x, rv.y, newAction, curr));
            }
        }

        return Math.min(cost[m-1][n-1][0], cost[m-1][n-1][1]);
    }
}