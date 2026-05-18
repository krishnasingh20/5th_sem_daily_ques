class Solution {
    public int minJumps(int[] arr) {
        int n = arr.length;

        HashMap<Integer, List<Integer>> map = new HashMap<>();

        for (int i = 0; i < n; i++) {
            map.putIfAbsent(arr[i], new ArrayList<>());
            map.get(arr[i]).add(i);
        }

        Queue<Integer> q = new ArrayDeque<>();
        boolean[] visited = new boolean[n];

        q.add(0);
        visited[0] = true;
        int step = 0;

        while (!q.isEmpty()) {
            int size = q.size();

            while (size-- > 0) {
                int rv = q.poll();

                if (rv == n - 1) {
                    return step;
                }

                if (rv - 1 >= 0 && !visited[rv - 1]) {
                    visited[rv - 1] = true;
                    q.add(rv - 1);
                }

                if (rv + 1 < n && !visited[rv + 1]) {
                    visited[rv + 1] = true;
                    q.add(rv + 1);
                }

                if (map.containsKey(arr[rv])) {
                    List<Integer> ll = map.get(arr[rv]);

                    for (int l : ll) {
                        if (!visited[l]) {
                            visited[l] = true;
                            q.add(l);
                        }
                    }

                    map.remove(arr[rv]);
                }
            }

            step++;
        }

        return -1;
    }
}