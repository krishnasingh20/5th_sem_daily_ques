class Solution {
    public int minOperations(int n, int m) {
        if(isPrime(n)) {
            return -1;
        }
        PriorityQueue<Pair> pq = new PriorityQueue<>((a, b)->Integer.compare(a.cost, b.cost));
        HashSet<Integer> visited = new HashSet<>();
        int[] dist = new int[10001];
        Arrays.fill(dist, Integer.MAX_VALUE);
        dist[n] = n;
        pq.add(new Pair(n, n));
        while(!pq.isEmpty()) {
            Pair rv = pq.poll();
            if(rv.n == m) {
                return rv.cost;
            }
            visited.add(rv.n);
            char[] ch = (Integer.toString(rv.n)).toCharArray();
            for(int i = 0; i < ch.length; i++) {
                char c = ch[i];
                // operation1-increase
                if((c-'0') < 9) {
                    ch[i] = (char)(c+1);
                    int curr = Integer.parseInt((new String(ch)));
                    int cost = rv.cost+curr;
                    if(!isPrime(curr) && dist[curr] > cost) {
                        dist[curr] = cost;
                        pq.add(new Pair(curr, cost));
                    }
                }
                //operation2-decrease
                if((c-'0') > 0) {
                    ch[i] = (char)(c-1);
                    int curr = Integer.parseInt((new String(ch)));
                    int cost = rv.cost+curr;
                    if(!isPrime(curr) && dist[curr] > cost) {
                        dist[curr] = cost;
                        pq.add(new Pair(curr, cost));
                    }
                }
                ch[i] = c;
            }
        }
        return -1;
    }
    public boolean isPrime(int n) {
        if(n <= 1) {
            return false;
        }
        if(n == 2 || n == 3) {
            return true;
        }
        if(n % 2 == 0 || n % 3 == 0) {
            return false;
        }
        int limit = (int)Math.sqrt(n);
        for(int i = 5; i <= limit; i += 6) {
            if(n % i == 0 || n % (i+2) == 0) {
                return false;
            }
        }
        return true;
    }
    class Pair{
        int n;
        int cost;
        Pair(int n, int cost) {
            this.n = n;
            this.cost = cost;
        }
    }
}