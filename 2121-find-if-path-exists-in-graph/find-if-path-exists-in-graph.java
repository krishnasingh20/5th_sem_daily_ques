class Solution {
    public boolean validPath(int n, int[][] edges, int src, int des) {
        HashMap<Integer, List<Integer>> map=new HashMap<>();
        for (int i=0;i<n;i++){
            map.put(i,new ArrayList<>());
        }
        for(int[] edge:edges){
            int v1=edge[0];
            int v2=edge[1];
            map.get(v1).add(v2);
            map.get(v2).add(v1);
        }
        return bft(map,src,des);
    }
    public boolean bft(HashMap<Integer,List<Integer>> map,int src,int des){
        Queue<Integer> q=new LinkedList<>();
        HashSet<Integer> visited=new HashSet<>();
        q.add(src);
        while(!q.isEmpty()){
            // remove
            int r=q.poll();
            // ignore if already visited
            if(visited.contains(r)){
                continue;
            }
            // marked visited
            visited.add(r);
            // self work
            if(r==des){
                return true;
            }
            // add unvisited nbrs
            for(int nbrs:map.get(r)){
                if(!visited.contains(nbrs)){
                    q.add(nbrs);
                }
            }
        }
        return false;
    }

}