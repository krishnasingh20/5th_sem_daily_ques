class Solution {
    public int[] findOrder(int numCourses, int[][] prerequisites) {
        HashMap<Integer, List<Integer>> map = new HashMap<>();
        for(int i = 0; i < numCourses; i++) {
            map.put(i, new ArrayList<>());
        }
        int[] inDegree = new int[numCourses];
        for(int[] pre: prerequisites) {
            inDegree[pre[0]]++;
            map.get(pre[1]).add(pre[0]);
        }
        Queue<Integer> q = new LinkedList<>();
        for(int i = 0; i < inDegree.length; i++) {
            if(inDegree[i] == 0) {
                q.add(i);
            }
        }
        int[] ans = new int[numCourses];
        int idx = 0;
        while(!q.isEmpty()) {
            int rv = q.poll();
            ans[idx] = rv;
            idx++;
            for(int nbrs: map.get(rv)) {
                inDegree[nbrs]--;
                if(inDegree[nbrs] == 0) {
                    q.add(nbrs);
                }
            }
        }
        if(idx == numCourses) {
            return ans;
        }
        return new int[0];
    }
}