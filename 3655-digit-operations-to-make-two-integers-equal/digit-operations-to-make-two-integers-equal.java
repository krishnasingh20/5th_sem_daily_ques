class Solution {
    static int limit = 10001;
    boolean[] isPrime;
    public int minOperations(int n, int m) {
        sieve();
        if(isPrime[n]) {
            return -1;
        }
        PriorityQueue<Pair> pq = new PriorityQueue<>((a, b)->Integer.compare(a.cost, b.cost));
        HashSet<Integer> visited = new HashSet<>();
        int[] dist = new int[limit];
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
                    if(!isPrime[curr] && dist[curr] > cost) {
                        dist[curr] = cost;
                        pq.add(new Pair(curr, cost));
                    }
                }
                //operation2-decrease
                if((c-'0') > 0) {
                    ch[i] = (char)(c-1);
                    int curr = Integer.parseInt((new String(ch)));
                    int cost = rv.cost+curr;
                    if(!isPrime[curr] && dist[curr] > cost) {
                        dist[curr] = cost;
                        pq.add(new Pair(curr, cost));
                    }
                }
                ch[i] = c;
            }
        }
        return -1;
    }
    public void sieve() {
        isPrime = new boolean[limit];
        Arrays.fill(isPrime, true);
        isPrime[0] = isPrime[1] = false;
        for(int i = 2; i * i < limit; i++) {
            if(isPrime[i]) {
                for(int j = i * i; j < limit; j += i) {
                    isPrime[j] = false;
                }
            }
        }
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