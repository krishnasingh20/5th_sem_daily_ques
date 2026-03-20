class Solution {

    class DSU {
        int[] parent;
        int[] size;

        public DSU(int n) {
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

    public int[] groupStrings(String[] words) {
        int n = words.length;

        HashMap<Integer, Integer> map = new HashMap<>();

        DSU dsu = new DSU(n);

        for(int i = 0; i < n; i++) {

            int mask = 0;

            for(int j = 0; j < words[i].length(); j++) {
                int x = words[i].charAt(j) - 'a';
                mask |= (1 << x);
            }

            // operation first-> add one letter
            for(int j = 0; j < 26; j++) {
                if((mask & (1 << j)) == 0) { //we only add that letter which are not present because every word has unique letter
                    mask ^= (1 << j);
                    
                    if(map.containsKey(mask)) {
                        dsu.union(i, map.get(mask));
                    }

                    mask ^= (1 << j);
                }
            }

            // operation second-> delete exactly one letter
            for(int j = 0; j < 26; j++) {
                if((mask & (1 << j)) != 0) {
                    mask ^= (1 << j);
                    
                    if(map.containsKey(mask)) {
                        dsu.union(i, map.get(mask));
                    }

                    mask ^= (1 << j);
                }
            }

            // operation third-> replace exactly one letter
            for(int j = 0; j < 26; j++) {
                if((mask & (1 << j)) != 0) {
                    mask ^= (1 << j);

                    for(int k = 0; k < 26; k++) {
                        if((mask & (1 << k)) != 0) {
                            continue;
                        }

                        mask ^= (1 << k);

                        if(map.containsKey(mask)) {
                            dsu.union(i, map.get(mask));
                        }

                        mask ^= (1 << k);
                    }

                    mask ^= (1 << j);
                }
            }

            map.put(mask, i);
        }

        HashSet<Integer> parent = new HashSet<>();

        for(int i = 0; i < n; i++) {
            int p = dsu.find(i);
            parent.add(p);
        }

        int maxGroup = 0;

        for(int p: parent) {
            int size = dsu.size[p];

            maxGroup = Math.max(maxGroup, size);
        }

        return new int[]{parent.size(), maxGroup};
    }
}