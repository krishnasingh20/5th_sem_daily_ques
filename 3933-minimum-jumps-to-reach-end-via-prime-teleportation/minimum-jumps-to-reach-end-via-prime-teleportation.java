class Solution {
    static final int MAX = 1000000;
    static List<Integer>[] factors = new ArrayList[MAX + 1];
    static {

        for(int i = 0; i <= MAX; i++) {
            factors[i] = new ArrayList<>();
        }

        for(int i = 2; i <= MAX; i++) {

            if(factors[i].isEmpty()) {

                for(int j = i; j <= MAX; j += i) {
                    factors[j].add(i);
                }
            }
        }
    }
    public int minJumps(int[] nums) {
        HashMap<Integer, List<Integer>> map = new HashMap<>();
        int n = nums.length;

        for(int i = 0; i < n; i++) {

            for(int p : factors[nums[i]]) {

                map.putIfAbsent(p, new ArrayList<>());

                map.get(p).add(i);
            }
        }

        return minJump(nums, map);
    }
    private int minJump(int[] nums, HashMap<Integer, List<Integer>> map) {
        int n = nums.length;
        boolean[] visited = new boolean[n];
        Queue<Integer> q = new ArrayDeque<>();
        q.add(0);
        int move = 0;
        visited[0] = true;
        while(!q.isEmpty()) {
            int size = q.size();
            while(size-- > 0) {
                int rv = q.poll();
                if(rv == n-1) {
                    return move;
                }
                if(rv-1 >= 0 && !visited[rv-1]) {
                    visited[rv-1] = true;
                    q.add(rv-1);
                }
                if(rv+1 < n && !visited[rv+1]) {
                    visited[rv+1] = true;
                    q.add(rv+1);
                }
                // teleport only if current number is prime
                if(factors[nums[rv]].size() == 1) {

                    int p = nums[rv];

                    if(map.containsKey(p)) {

                        for(int idx : map.get(p)) {

                            if(!visited[idx]) {

                                visited[idx] = true;

                                q.add(idx);
                            }
                        }

                        // important optimization
                        map.get(p).clear();
                    }
                }
            }
            move++;
        }
        return -1;
    }
}