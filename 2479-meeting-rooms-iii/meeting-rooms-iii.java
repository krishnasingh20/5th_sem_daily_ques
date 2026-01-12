class Solution {
    public int mostBooked(int n, int[][] meetings) {
        Arrays.sort(meetings, (a, b)->Integer.compare(a[0], b[0]));
        PriorityQueue<Pair> pq = new PriorityQueue<>(new Comparator<>(){
            @Override
            public int compare(Pair a, Pair b) {
                if(a.time == b.time) {
                    return a.r-b.r;
                }
                return Long.compare(a.time, b.time);
            }
        });
        TreeSet<Integer> set = new TreeSet<>();
        int[] ans = new int[n];
        for(int i = 0; i < n; i++) {
            set.add(i);
        }
        for(int i = 0; i < meetings.length; i++) {
            int start = meetings[i][0];
            int end = meetings[i][1];
            while(!pq.isEmpty() && pq.peek().time <= start) {
                set.add(pq.poll().r);
            }
            if(set.size() > 0) {
                int idx = set.pollFirst();
                ans[idx]++;
                pq.add(new Pair(idx, end));
            }
            else {
                Pair rv = pq.poll();
                ans[rv.r]++;
                rv.time += (end-start);
                pq.add(rv);
            }
        }
        int ans1 = 0;
        int idx = -1;
        for(int i = 0; i < n; i++) {
            if(ans1 < ans[i]) {
                ans1 = ans[i];
                idx = i;
            }
        }
        return idx;
    }
    class Pair{
        int r;
        long time;
        Pair(int r, long time) {
            this.r = r;
            this.time = time;
        }
    }
}