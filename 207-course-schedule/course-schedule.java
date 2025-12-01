class Solution {
    public boolean canFinish(int numCourses, int[][] prerequisites) {
        HashMap<Integer, List<Integer>> map = new HashMap<>();
        for(int i = 0; i < numCourses; i++) {
            map.put(i, new ArrayList<>());
        }
        int[] inDegree = new int[numCourses];
        for(int[] pre: prerequisites) {
            inDegree[pre[1]]++;
            map.get(pre[0]).add(pre[1]);
        }
        Queue<Integer> q = new LinkedList<>();
        for(int i = 0; i < inDegree.length; i++) {
            if(inDegree[i] == 0) {
                q.add(i);
            }
        }
        int count = 0;
        while(!q.isEmpty()) {
            int rv = q.poll();
            count++;
            for(int nbrs: map.get(rv)) {
                inDegree[nbrs]--;
                if(inDegree[nbrs] == 0) {
                    q.add(nbrs);
                }
            }
        }
        return count == numCourses;
    }
}