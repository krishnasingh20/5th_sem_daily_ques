class Solution {
    static int MAX = 1000000;
    static int[] spf = new int[1000001];
    static {
        for(int i = 0; i <= MAX; i++) {
            spf[i] = i;
        }
        spf[0] = spf[1] = -1;
        for(int i = 2; i * i <= MAX; i++) {
            if(spf[i] == i) {
                for(int j = i * i; j <= MAX; j += i) {
                    if(spf[j] == j) {
                        spf[j] = i;
                    }
                }
            }
        }
    }
    public int minJumps(int[] nums) {
        int n = nums.length;
        HashMap<Integer, List<Integer>> map = new HashMap<>();
        for(int i = 0; i < n; i++) {
            if(spf[nums[i]] == nums[i]) {
                map.putIfAbsent(nums[i], new ArrayList<>());
                map.get(nums[i]).add(i);
            }
            else {
                int num = nums[i];
                while(num > 1) {
                    int x = spf[num];
                    map.putIfAbsent(x, new ArrayList<>());
                    map.get(x).add(i);
                    while(num % x == 0) {
                        num /= x;
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
                if(spf[nums[rv]] == nums[rv] && map.containsKey(nums[rv])) {
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