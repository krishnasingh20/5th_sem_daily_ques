class Solution {
    static boolean[] isPrime = new boolean[1000001];
    static {
        Arrays.fill(isPrime, true);
        isPrime[0] = isPrime[1] = false;

        for(int i = 2; (long)i * i <= 1000000; i++) {
            if(isPrime[i]) {
                for(int j = i * i; j <= 1000000; j += i) {
                    isPrime[j] = false;
                }
            }
        }
    }
    public int minJumps(int[] nums) {
        int n = nums.length;
        HashMap<Integer, List<Integer>> map = new HashMap<>();
        for(int i = 0; i < n; i++) {
            int limit = (int)Math.sqrt(nums[i]);
            for(int j = 1; j <= limit; j++) {
                if(nums[i] % j == 0) {
                    if(isPrime[j]) {
                        map.putIfAbsent(j, new ArrayList<>());
                        map.get(j).add(i);
                    }
                    if(nums[i]/j != j && isPrime[nums[i]/j]) {
                        map.putIfAbsent(nums[i]/j, new ArrayList<>());
                        map.get(nums[i]/j).add(i);
                    }
                }
            }
        }
        return minJump(nums, map);
    }
    private int minJump(int[] nums, HashMap<Integer, List<Integer>> map) {
        int n = nums.length;
        boolean[] visited = new boolean[n];
        Queue<Integer> q = new LinkedList<>();
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
                if(isPrime[nums[rv]] && map.containsKey(nums[rv])) {
                    List<Integer> ll = map.get(nums[rv]);
                    for(int j = 0; j < ll.size(); j++) {
                        if(!visited[ll.get(j)]) {
                            q.add(ll.get(j));
                            visited[ll.get(j)] = true;
                        }
                    }
                    map.remove(nums[rv]);
                }
            }
            move++;
        }
        return -1;
    }
}