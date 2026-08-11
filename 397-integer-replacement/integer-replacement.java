class Solution {
    public int integerReplacement(int n) {
        int opr = 0;
        HashSet<Long> visited = new HashSet<>();
        Queue<Long> q = new LinkedList<>();
        q.add((long)n);
        visited.add((long)n);

        while(!q.isEmpty()) {
            int size = q.size();
            while(size-- > 0) {
                long rv = q.poll();
                if(rv == 1) {
                    return opr;
                }
                if((rv & 1) == 1) {
                    if(!visited.contains(rv+1)) {
                        visited.add(rv+1);
                        q.add(rv+1);
                    }
                    if(!visited.contains(rv-1)) {
                        visited.add(rv-1);
                        q.add(rv-1);
                    }
                }
                else {
                    if(!visited.contains(rv/2)) {
                        visited.add(rv/2);
                        q.add(rv/2);
                    }
                }
            }
            opr++;
        }

        return -1;
    }
}