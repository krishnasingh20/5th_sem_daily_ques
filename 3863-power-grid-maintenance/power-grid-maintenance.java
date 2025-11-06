class Solution {
    public int[] processQueries(int c, int[][] connections, int[][] queries) {
        // graph creation
        HashMap<Integer, List<Integer>> map = new HashMap<>();
        for(int i = 1; i <= c; i++) {
            map.put(i, new ArrayList<>());
        }
        for(int[] edge: connections) {
            map.get(edge[0]).add(edge[1]);
            map.get(edge[1]).add(edge[0]);
        }
        HashMap<Integer, Integer> map1 = new HashMap<>();//mapping each vertex with there respective component id
        int cID = 1;//component ID
        HashSet<Integer> visited = new HashSet<>();
        Queue<Integer> q = new LinkedList<>();
        HashMap<Integer, TreeSet<Integer>> com = new HashMap<>();
        for(int key: map.keySet()) {
            if(visited.contains(key)) {
                continue;
            }
            com.put(cID, new TreeSet<>());
            q.add(key);
            while(!q.isEmpty()) {
                //remove
                int rv = q.poll();
                //ignore
                if(visited.contains(rv)) {
                    continue;
                }
                //mark visited
                visited.add(rv);
                //self work
                map1.put(rv, cID);
                com.get(cID).add(rv);
                //add unvisited neighour in the queue
                for(int nbrs: map.get(rv)) {
                    if(!visited.contains(nbrs)) {
                        q.add(nbrs);
                    }
                }
            }
            cID++;
        }
        //queries processing
        int idx = 0;
        for(int[] query: queries) {
            if(query[0] == 1) {
                idx++;
            }
        }
        int[] ans = new int[idx];
        idx = 0;
        for(int[] query: queries) {
            int cid = map1.get(query[1]);
            if(query[0] == 1) {
                if(com.get(cid).contains(query[1])) {
                    ans[idx] = query[1];
                    idx++;
                }
                else if(com.get(cid).size() > 0) {
                    ans[idx] = com.get(cid).first();
                    idx++;
                }
                else {
                    ans[idx] = -1;
                    idx++;
                }
            }
            else {
                if(com.get(cid).contains(query[1])) {
                    com.get(cid).remove(query[1]);
                }
            }
        }
        return ans;
    }
}