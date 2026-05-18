class Solution {
    public boolean canReach(String s, int minJump, int maxJump) {
        int n = s.length();

        if(s.charAt(n-1) == '1') {
            return false;
        }
        
        Queue<Integer> q = new LinkedList<>();
        q.add(0);
        int prev = -1;

        while(!q.isEmpty()) {
            int rv = q.poll();
            if(rv == n-1) {
                return true;
            }

            int j1 = rv+minJump;
            int j2 = Math.min(rv+maxJump, n-1);
            
            if(prev >= j2) {
                continue;
            }

            int j = Math.max(prev+1, j1);

            for(int k = j; k <= j2; k++) {
                if(s.charAt(k) == '0') {
                    q.add(k);
                }
            }

            prev = Math.max(prev, j2);
        }

        return false;
    }
}