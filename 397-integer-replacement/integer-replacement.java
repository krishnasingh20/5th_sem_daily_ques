class Solution {
    public int integerReplacement(int n) {
        int opr = 0;

        Queue<Long> q = new LinkedList<>();
        q.add((long)n);

        while(!q.isEmpty()) {
            int size = q.size();
            while(size-- > 0) {
                long rv = q.poll();
                if(rv == 1) {
                    return opr;
                }
                if((rv & 1) == 1) {
                    q.add(rv+1);
                    q.add(rv-1);
                }
                else {
                    q.add(rv/2);
                }
            }
            opr++;
        }

        return -1;
    }
}