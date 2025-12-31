class Solution {
    public int[] findOrder(int numCourses, int[][] prerequisites) {
        List<Integer>[] graph = new ArrayList[numCourses];
        for(int i = 0; i < numCourses; i++) {
            graph[i] = new ArrayList<>();
        }
        int[] inDegree = new int[numCourses];
        for(int[] pre: prerequisites) {
            inDegree[pre[0]]++;
            graph[pre[1]].add(pre[0]);
        }
        Queue<Integer> q = new LinkedList<>();
        for(int i = 0; i < numCourses; i++) {
            if(inDegree[i] == 0) {
                q.add(i);
            }
        }
        int course = 0;
        int[] ans = new int[numCourses];
        while(!q.isEmpty()) {
            int rv = q.poll();
            ans[course] = rv;
            course++;
            for(int nbrs: graph[rv]) {
                if(--inDegree[nbrs] == 0) {
                    q.add(nbrs);
                }
            }
        }
        return course==numCourses?ans:new int[]{};
    }
}