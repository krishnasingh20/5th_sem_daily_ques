class Solution {
    HashMap<Integer,HashMap<Integer,Integer>> mp;
    public int findCheapestPrice(int n, int[][] flights, int src, int dst, int k) {
        mp=new HashMap<>();
        for(int i=0;i<n;i++){
            mp.put(i,new HashMap<>());
        }
        for(int[] e:flights){
            int v1=e[0];
            int v2=e[1];
            int cost=e[2];
            mp.get(v1).put(v2,cost);
        }
        return path(dst,k,src);
    }
    public int path(int dst,int k,int src){
        PriorityQueue<Pair> pq=new PriorityQueue<>((a,b)->a.cost-b.cost);
        pq.add(new Pair(src,0,k+1));
        int[] best = new int[mp.size()];//prevents from exploring worse states of the same vertex
        Arrays.fill(best, -1);

        while(!pq.isEmpty()){
            // remove
            Pair rp=pq.poll();

            if(rp.vtx==dst){
                return rp.cost;
            }

            if(best[rp.vtx] >= rp.mk){
                continue;
            }
            best[rp.vtx] = rp.mk;

            // add nbrs
            if(rp.mk>0){
                for(int nbrs:mp.get(rp.vtx).keySet()){
                        int cost=mp.get(rp.vtx).get(nbrs);
                        pq.add(new Pair(nbrs,rp.cost+cost,rp.mk-1));
                    
                }
            }
        }
        return -1;
    }
    class Pair{
        int vtx;
        int cost;
        int mk;
        Pair(int vtx,int cost,int mk){
            this.vtx=vtx;
            this.cost=cost;
            this.mk=mk;
        }
    }
}