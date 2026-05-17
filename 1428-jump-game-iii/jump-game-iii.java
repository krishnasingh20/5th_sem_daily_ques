class Solution {
    public boolean canReach(int[] arr, int start) {
        int n = arr.length;

        boolean[] visited = new boolean[n];
        Queue<Integer> q = new LinkedList<>();

        q.add(start);
        visited[start] = true;

        while(!q.isEmpty()) {
            int rv = q.poll();
            
            if(arr[rv] == 0) {
                return true;
            }

            if(rv+arr[rv] < n && !visited[rv+arr[rv]]) {
                visited[rv+arr[rv]] = true;
                q.add(rv+arr[rv]);
            }

            if(rv-arr[rv] >= 0 && !visited[rv-arr[rv]]) {
                visited[rv-arr[rv]] = true;
                q.add(rv-arr[rv]);
            }
        }

        return false;
    }
}