import java.util.*;

class Solution {

    class DSU {
        int[] parent;
        int[] size;

        DSU(int n) {
            parent = new int[n];
            size = new int[n];
            for(int i = 0; i < n; i++) {
                parent[i] = i;
                size[i] = 1;
            }
        }

        int find(int x) {
            if(parent[x] != x) {
                parent[x] = find(parent[x]);
            }
            return parent[x];
        }

        void union(int a, int b) {
            int p1 = find(a);
            int p2 = find(b);

            if(p1 == p2) return;

            if(size[p1] < size[p2]) {
                parent[p1] = p2;
                size[p2] += size[p1];
            } else {
                parent[p2] = p1;
                size[p1] += size[p2];
            }
        }
    }

    public int maxActivated(int[][] points) {

        int n = points.length;

        int[] xs = new int[n];
        int[] ys = new int[n];

        for(int i = 0; i < n; i++){
            xs[i] = points[i][0];
            ys[i] = points[i][1];
        }

        Arrays.sort(xs);
        Arrays.sort(ys);

        HashMap<Integer,Integer> cx = new HashMap<>();
        HashMap<Integer,Integer> cy = new HashMap<>();

        int id = 0;
        for(int x : xs){
            if(!cx.containsKey(x)){
                cx.put(x, id++);
            }
        }

        for(int y : ys){
            if(!cy.containsKey(y)){
                cy.put(y, id++);
            }
        }

        DSU dsu = new DSU(id);
        HashSet<Integer> used = new HashSet<>();

        for(int[] p: points) {
            int x = cx.get(p[0]);
            int y = cy.get(p[1]);
            used.add(x);
            used.add(y);
            dsu.union(x, y);
        }
        
        HashSet<Integer> parent = new HashSet<>();//it will help to know number of component

        for(int a: used) {
            parent.add(dsu.find(a));
        }

        if(parent.size() == 1) {
            return n+1;
        }

        List<Integer> componentSize = new ArrayList<>();

        for(int p: parent) {
            componentSize.add(dsu.size[p]);
        }

        Collections.sort(componentSize);
        
        int maxPoint = componentSize.get(componentSize.size()-1) + componentSize.get(componentSize.size()-2) - 1;

        return maxPoint;
    }
}