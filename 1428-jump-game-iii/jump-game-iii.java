class Solution {
    public boolean canReach(int[] arr, int start) {
        Queue<Integer> q = new LinkedList<>();
        boolean[] visited = new boolean[arr.length];
        q.add(start);
        while(!q.isEmpty()) {
            int rv = q.poll();
            if(visited[rv]) {
                continue;
            }
            visited[rv] = true;
            if(arr[rv] == 0) {
                return true;
            }
            if(rv-arr[rv] >= 0) {
                q.add(rv-arr[rv]);
            }
            if(rv+arr[rv] < arr.length) {
                q.add(rv+arr[rv]);
            }
        }
        return false;
    }
}