class Solution {
    class DSU {
        int[] parent;
        int[] size;
        int n;
        
        public DSU(int n) {
            this.n = n;
            parent = new int[n];
            size = new int[n];

            for(int i = 0; i < n; i++) {
                parent[i] = i;
                size[i] = 1;
            }
        }

        int find(int node) {
            if(node == parent[node]) {
                return node;
            }
            return parent[node] = find(parent[node]);
        }

        void union(int a, int b) {
            int p1 = find(a);
            int p2 = find(b);

            if(p1 == p2) {
                return;
            }

            if(size[p1] > size[p2]) {
                parent[p2] = p1;
                size[p1] += size[p2];
            }
            else {
                parent[p1] = p2;
                size[p2] += size[p1];
            }
        }
    }
    public List<List<String>> accountsMerge(List<List<String>> accounts) {
        
        int n = accounts.size();
        HashMap<String, List<Integer>> map = new HashMap<>();

        DSU dsu = new DSU(n);

        for(int i = 0; i < n; i++) {
            List<String> account = accounts.get(i);
            for(int j = 1; j < account.size(); j++) {
                String email = account.get(j);
                if(!map.containsKey(email)) {
                    map.put(email, new ArrayList<>());
                }
                else {
                    List<Integer> ll = map.get(email);
                    for(int l: ll) {
                        dsu.union(i, l);
                    }
                }
                map.get(email).add(i);
            }
        }
        HashMap<Integer, TreeSet<String>> map1 = new HashMap<>();
        for(int i = 0; i < n; i++) {
            int p = dsu.find(i);
            if(!map1.containsKey(p)) {
                TreeSet<String> set = new TreeSet<>();
                map1.put(p, set);
            }
            TreeSet<String> set = map1.get(p);
            List<String> l = accounts.get(i);
            for(int j = 1; j < l.size(); j++) {
                set.add(l.get(j));
            }
        }
        List<List<String>> ans = new ArrayList<>();
        for(int key: map1.keySet()) {
            TreeSet<String> set = map1.get(key);
            List<String> ll = new ArrayList<>();
            ll.add(accounts.get(key).get(0));
            for(String s: set) {
                ll.add(s);
            }
            ans.add(ll);
        }
        return ans;
    }
}