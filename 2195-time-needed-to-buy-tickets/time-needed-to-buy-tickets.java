class Solution {
    public int timeRequiredToBuy(int[] tickets, int k) {
        int n = tickets.length;
        Queue<Integer> q = new LinkedList<>();
        for(int i = 0; i < n; i++) {
            q.add(i);
        }
        int time = 1;
        while(!q.isEmpty()) {
            int rv = q.poll();
            tickets[rv]--;
            if(tickets[rv] == 0) {
                if(rv == k) {
                    return time;
                }
                time++;
                continue;
            }
            q.add(rv);
            time++;
        }
        return -1;
    }
}