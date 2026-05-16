class Solution {

    static int MAX = 1000000;
    static int[] spf = new int[MAX+1];

    static {
        for(int i = 0; i <= MAX; i++) {
            spf[i] = i;
        }
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
            int num = nums[i];
            int x = 0;

            while(num > 1) {
                x = spf[num];
                map.putIfAbsent(x, new ArrayList<>());
                map.get(x).add(i);

                while(num % x == 0) {
                    num /= x;
                }
            }
        }

        Queue<Integer> q = new LinkedList<>();
        boolean[] visited = new boolean[n];

        int move = 0;
        q.add(0);
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
                    for(int l: ll) {
                        if(!visited[l]) {
                            visited[l] = true;
                            q.add(l);
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